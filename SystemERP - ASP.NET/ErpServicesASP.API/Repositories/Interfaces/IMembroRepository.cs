using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface IMembroRepository
    {
        Task<MemberGetIdDto> GetMembroPorId(int membroId);
        Task<MemberModel> CriarMembro(MemberCreateDto novoMembro, UserModel usuario, PositionModel cargo, EnterpriseModel empresa);
        Task<List<MemberGetIdDto>> ListarMembros();
        Task<bool> MembroJaExiste(MemberCreateDto novoMembro);
    }
}
