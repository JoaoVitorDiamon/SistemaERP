using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface IMembroRepository
    {
        Task<MembroGetIdDto> GetMembroPorId(int membroId);
        Task<MembroModel> CriarMembro(MembroModel novoMembro);
        Task<List<MembroGetIdDto>> ListarMembros();
        Task<bool> MembroJaExiste(MembroCreateDto novoMembro);
    }
}
