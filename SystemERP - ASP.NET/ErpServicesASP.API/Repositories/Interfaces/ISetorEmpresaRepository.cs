using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface ISetorEmpresaRepository
    {
        Task<SectorModel> GetSetorEmpresaPorID(int id);
        Task<List<SectorModel>> ListarSetoresEmpresa();
        Task<SectorModel> CriarSetorEmpresa(SectorCreateDto novoSetor);
        Task<List<SectorModel>> DeletarSetorEmpresa(SectorModel setor);
        Task<SectorModel> AtualizarSetorEmpresa(SectorModel setor);
        Task<bool> SetorEmpresaJaExiste(string nomeSetor);
    }
}
