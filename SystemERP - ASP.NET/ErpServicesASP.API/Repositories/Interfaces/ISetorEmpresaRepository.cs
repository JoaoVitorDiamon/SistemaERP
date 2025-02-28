using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface ISetorEmpresaRepository
    {
        Task<SetorModel> GetSetorEmpresaPorID(int id);
        Task<List<SetorModel>> ListarSetoresEmpresa();
        Task<SetorModel> CriarSetorEmpresa(SectorCreateDto novoSetor);
        Task<List<SetorModel>> DeletarSetorEmpresa(SetorModel setor);
        Task<SetorModel> AtualizarSetorEmpresa(SetorModel setor);
        Task<bool> SetorEmpresaJaExiste(string nomeSetor);
    }
}
