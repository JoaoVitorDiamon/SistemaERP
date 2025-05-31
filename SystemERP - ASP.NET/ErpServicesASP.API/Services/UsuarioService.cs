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
     //   private readonly IValidacaoEmailService _validacaoEmailService;

        public UsuarioService(IUsuarioRepository usuarioRepository)
        {
            _usuarioRepository = usuarioRepository;
         //   _validacaoEmailService = validacaoEmailService;
        }

        public async Task<ResponseModel<string>> VerificarExistenciaCPF(string cpf)
        {
            ResponseModel<string> response = new ResponseModel<string>();
            try
            {
                var usuarioDoCPF = await _usuarioRepository.VerificarExistenciaCPF(cpf);
                if (usuarioDoCPF)
                {
                    response.Valor = "Usado";
                    return response;
                }
                response.Valor = "Não usado";
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<string>> VerificarExistenciaEmail(string email)
        {
            ResponseModel<string> response = new ResponseModel<string>();
            try
            {
                var usuarioDoEmail = await _usuarioRepository.VerificarExistenciaEmail(email);
                if (usuarioDoEmail)
                {
                    response.Valor = "Usado";
                    return response;
                }
                response.Valor = "Não usado";
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<UserModel>> CriarUsuario(UsuarioCreateDto novoUsuario)
        {
            ResponseModel<UserModel> response = new ResponseModel<UserModel>();
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

              //  await _validacaoEmailService.EnviarEmailValidacao(usuario);
                response.Valor = usuario;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro:" + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<List<UserModel>>> DeletarUsuarioPorId(int id)
        {
            ResponseModel<List<UserModel>> response = new ResponseModel<List<UserModel>>();
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

        public async Task<ResponseModel<UserModel>> GetUsuarioPorId(int id)
        {
            ResponseModel<UserModel> response = new ResponseModel<UserModel>();
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

        public async Task<ResponseModel<List<UserModel>>> ListarUsuarios()
        {
            ResponseModel<List<UserModel>> response = new ResponseModel<List<UserModel>>();
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

        public async Task<ResponseModel<UserModel>> LoginUser(string email, string password)
        {
            ResponseModel<UserModel> response = new ResponseModel<UserModel>();
            try
            {
                var usuario = await _usuarioRepository.LoginUser(email, password);
                if (usuario == null)
                {
                    response.setErro("Usuário ou senha inválidos");
                    return response;
                }
                response.Valor = usuario;
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
