using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface ITipoDeEmpresaRepository
    {
        Task<TipoDeEmpresaModel> GetTipoDeEmpresaPorID(int id);
        Task<List<TipoDeEmpresaModel>> ListarTiposDeEmpresa();
        Task<TipoDeEmpresaModel> CriarTipoDeEmpresa(EnterpriseTypeCreateDto novoTipoDeEmpresa);
        Task<List<TipoDeEmpresaModel>> DeletarTipoDeEmpresa(TipoDeEmpresaModel tipoDeEmpresa);
        Task<TipoDeEmpresaModel> AtualizarTipoDeEmpresa(TipoDeEmpresaModel tipoDeEmpresa);
        Task<bool> tipoJaExiste(string nomeTipoDeEmpresa);
    }
}
