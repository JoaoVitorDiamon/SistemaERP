using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services.Interfaces;
using Microsoft.AspNetCore.Http.HttpResults;

namespace ErpServicesASP.API.Services
{
    public class UsuarioService : IUsuarioService
    {
        private readonly IUsuarioRepository _usuarioRepository;
        private readonly IValidacaoEmailService _validacaoEmailService;

        public UsuarioService(IUsuarioRepository usuarioRepository, IValidacaoEmailService validacaoEmailService)
        {
            _usuarioRepository = usuarioRepository;
            _validacaoEmailService = validacaoEmailService;
        }

        public async Task<ResponseModel<UsuarioModel>> CriarUsuario(UsuarioCreateDto novoUsuario)
        {
            ResponseModel<UsuarioModel> response = new ResponseModel<UsuarioModel>();
            try
            {
                var usuarioExiste = await _usuarioRepository.UsuarioJaExiste(novoUsuario);
                if (usuarioExiste)
                {
                    response.setErro("Email ou CPF já cadastrados");
                    return response;
                }

                var usuario = await _usuarioRepository.CriarUsuario(novoUsuario);
                if (usuario == null)
                {
                    response.setErro("Erro ao criar usuário");
                    return response;
                }

                await _validacaoEmailService.EnviarEmailValidacao(usuario);
                response.Valor = usuario;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro:" + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<List<UsuarioModel>>> DeletarUsuarioPorId(int id)
        {
            ResponseModel<List<UsuarioModel>> response = new ResponseModel<List<UsuarioModel>>();
            try
            {
                var usuario = await _usuarioRepository.GetUsuarioPorId(id);
                if (usuario == null)
                {
                    response.setErro("Usuário não encontrado");
                    return response;
                }
                var lista = await _usuarioRepository.DeletarUsuario(usuario);
                response.Valor = lista;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<UsuarioModel>> GetUsuarioPorId(int id)
        {
            ResponseModel<UsuarioModel> response = new ResponseModel<UsuarioModel>();
            try
            {
                var usuario = await _usuarioRepository.GetUsuarioPorId(id);
                if (usuario == null)
                    response.setErro("Usuário não encontrado");
                response.Valor = usuario;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<List<UsuarioModel>>> ListarUsuarios()
        {
            ResponseModel<List<UsuarioModel>> response = new ResponseModel<List<UsuarioModel>>();
            try
            {
                var lista = await _usuarioRepository.ListarUsuarios();
                response.Valor = lista;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }
    }
}
