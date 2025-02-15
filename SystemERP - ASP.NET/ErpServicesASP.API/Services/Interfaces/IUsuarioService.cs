using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Services.Interfaces
{
    public interface IUsuarioService
    {
        Task<ResponseModel<UsuarioModel>> CriarUsuario(UsuarioCreateDto novoUsuario);
        Task<ResponseModel<List<UsuarioModel>>> ListarUsuarios();
        Task<ResponseModel<UsuarioModel>> getUsuarioPorId(int id);
        Task<ResponseModel<List<UsuarioModel>>> DeletarUsuarioPorId(int id);
    }
}
