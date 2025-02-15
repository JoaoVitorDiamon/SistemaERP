using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface IValidacaoEmailRepository
    {
        Task<ValidacaoEmailModel> CriarValidacao(UsuarioModel usuario);
        Task<ValidacaoEmailModel> ValidarEmail(ValidacaoEmailModel validar);
        Task<ValidacaoEmailModel> BuscarValidacaoPorEmail(string email);
        Task<bool> ValidacaoJaEnviada(UsuarioModel usuario);
    }
}
