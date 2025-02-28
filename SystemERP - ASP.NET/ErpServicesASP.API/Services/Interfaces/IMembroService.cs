using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Services.Interfaces
{
    public interface IMembroService
    {
        Task<ResponseModel<MemberGetIdDto>> GetMembroPorId(int membroId);
        Task<ResponseModel<MembroModel>> CriarMembro(MemberCreateDto novoMembro);
        Task<ResponseModel<List<MemberGetIdDto>>> ListarMembros();
    }
}
