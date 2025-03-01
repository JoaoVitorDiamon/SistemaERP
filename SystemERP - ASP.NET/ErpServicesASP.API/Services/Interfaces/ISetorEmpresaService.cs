using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Services.Interfaces
{
    public interface ISetorEmpresaService
    {
        Task<ResponseModel<SectorModel>> GetSetorEmpresaPorID(int id);
        Task<ResponseModel<List<SectorModel>>> ListarSetoresEmpresa();
        Task<ResponseModel<SectorModel>> CriarSetorEmpresa(SectorCreateDto novoSetor);
        Task<ResponseModel<List<SectorModel>>> DeletarSetorEmpresa(int id);
        Task<ResponseModel<SectorModel>> AtualizarSetorEmpresa(SectorModel setor);
    }
}
