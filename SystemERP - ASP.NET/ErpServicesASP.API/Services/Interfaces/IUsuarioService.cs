using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Services.Interfaces
{
    public interface IUsuarioService
    {
        Task<ResponseModel<UserModel>> CriarUsuario(UsuarioCreateDto novoUsuario);
        Task<ResponseModel<List<UserModel>>> ListarUsuarios();
        Task<ResponseModel<UserModel>> GetUsuarioPorId(int id);
        Task<ResponseModel<List<UserModel>>> DeletarUsuarioPorId(int id);
        Task<ResponseModel<string>> VerificarExistenciaCPF(string cpf);
        Task<ResponseModel<string>> VerificarExistenciaEmail(string cpf);
    }
}
