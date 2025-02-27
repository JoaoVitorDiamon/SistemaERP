using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface IUsuarioRepository
    {
        Task<UsuarioModel?> CriarUsuario(UsuarioCreateDto novoUsuario);
        Task<List<UsuarioModel>> ListarUsuarios();
        Task<UsuarioModel?> GetUsuarioPorId(int id);
        Task<bool> UsuarioJaExiste(UsuarioCreateDto novoUsuario);
        Task<List<UsuarioModel>> DeletarUsuario(UsuarioModel usuario);
        Task<bool> VerificarExistenciaCPF(string cpf);
        Task<bool> VerificarExistenciaEmail(string email);
    }
}
