using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services.Interfaces;

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

        public Task<ResponseModel<List<UsuarioModel>>> DeletarUsuarioPorId(int id)
        {
            throw new NotImplementedException();
        }

        public Task<ResponseModel<UsuarioModel>> getUsuarioPorId(int id)
        {
            throw new NotImplementedException();
        }

        public Task<ResponseModel<List<UsuarioModel>>> ListarUsuarios()
        {
            throw new NotImplementedException();
        }
    }
}
