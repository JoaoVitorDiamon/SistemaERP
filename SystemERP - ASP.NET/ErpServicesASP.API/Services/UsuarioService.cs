using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;

namespace ErpServicesASP.API.Services
{
    public class UsuarioService
    {
        private readonly IUsuarioRepository _usuarioRepository;
        private readonly IValidacaoEmailRepository _validacaoEmailRepository;
        public UsuarioService(IUsuarioRepository usuarioRepository, IValidacaoEmailRepository validacaoEmailRepository)
        {
            _usuarioRepository = usuarioRepository;
            _validacaoEmailRepository = validacaoEmailRepository;
        }

        public async Task<ResponseModel<UsuarioModel>> CriarUsuario(UsuarioCreateDto novoUsuario)
        {
            var response = await _usuarioRepository.CriarUsuario(novoUsuario);
            if (!response.Status)
                return response;
            await _validacaoEmailRepository.EnviarEmailValidacao(response.Valor);
            return response;
        }
    }
}
