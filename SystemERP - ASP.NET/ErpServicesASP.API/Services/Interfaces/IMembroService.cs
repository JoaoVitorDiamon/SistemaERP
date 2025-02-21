using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Services.Interfaces
{
    public interface IMembroService
    {
        Task<ResponseModel<MembroGetIdDto>> GetMembroPorId(int membroId);
        Task<ResponseModel<MembroModel>> CriarMembro(MembroCreateDto novoMembro);
        Task<ResponseModel<List<MembroGetIdDto>>> ListarMembros();
    }
}
