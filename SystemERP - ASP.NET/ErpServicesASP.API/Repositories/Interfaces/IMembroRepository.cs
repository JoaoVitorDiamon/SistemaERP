using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface IMembroRepository
    {
        Task<MemberGetIdDto> GetMembroPorId(int membroId);
        Task<MembroModel> CriarMembro(MemberCreateDto novoMembro, UsuarioModel usuario, CargoModel cargo, EmpresaModel empresa);
        Task<List<MemberGetIdDto>> ListarMembros();
        Task<bool> MembroJaExiste(MemberCreateDto novoMembro);
    }
}
