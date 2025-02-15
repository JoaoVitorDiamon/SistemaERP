using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface IValidacaoEmailRepository
    {
        Task<ResponseModel<string>> EnviarEmailValidacao(UsuarioModel usuario);
        Task<ResponseModel<string>> ValidarEmail(string email, string codigo);
        Task<bool> ValidacaoJaEnviada(UsuarioModel usuario);
    }
}
