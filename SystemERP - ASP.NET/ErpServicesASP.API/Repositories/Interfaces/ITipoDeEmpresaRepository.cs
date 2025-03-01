using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface ITipoDeEmpresaRepository
    {
        Task<EnterpriseTypeModel> GetTipoDeEmpresaPorID(int id);
        Task<List<EnterpriseTypeModel>> ListarTiposDeEmpresa();
        Task<EnterpriseTypeModel> CriarTipoDeEmpresa(EnterpriseTypeCreateDto novoTipoDeEmpresa);
        Task<List<EnterpriseTypeModel>> DeletarTipoDeEmpresa(EnterpriseTypeModel tipoDeEmpresa);
        Task<EnterpriseTypeModel> AtualizarTipoDeEmpresa(EnterpriseTypeModel tipoDeEmpresa);
        Task<bool> tipoJaExiste(string nomeTipoDeEmpresa);
    }
}
