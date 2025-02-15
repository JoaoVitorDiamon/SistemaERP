using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Services.Interfaces
{
    public interface ITipoDeEmpresaService
    {
        Task<ResponseModel<TipoDeEmpresaModel>> GetTipoDeEmpresaPorID(int id);
        Task<ResponseModel<List<TipoDeEmpresaModel>>> ListarTiposDeEmpresa();
        Task<ResponseModel<TipoDeEmpresaModel>> CriarTipoDeEmpresa(TipoDeEmpresaCreateDto novoTipoDeEmpresa);
        Task<ResponseModel<List<TipoDeEmpresaModel>>> DeletarTipoDeEmpresa(TipoDeEmpresaModel tipoDeEmpresa);
        Task<ResponseModel<TipoDeEmpresaModel>> AtualizarTipoDeEmpresa(TipoDeEmpresaModel tipoDeEmpresa);
    }
}
