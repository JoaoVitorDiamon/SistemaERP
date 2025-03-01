using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface IUsuarioRepository
    {
        Task<UserModel?> CriarUsuario(UsuarioCreateDto novoUsuario);
        Task<List<UserModel>> ListarUsuarios();
        Task<UserModel?> GetUsuarioPorId(int id);
        Task<bool> UsuarioJaExiste(UsuarioCreateDto novoUsuario);
        Task<List<UserModel>> DeletarUsuario(UserModel usuario);
        Task<bool> VerificarExistenciaCPF(string cpf);
        Task<bool> VerificarExistenciaEmail(string email);
    }
}
