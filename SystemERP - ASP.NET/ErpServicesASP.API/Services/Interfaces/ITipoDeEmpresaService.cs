using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Services.Interfaces
{
    public interface ITipoDeEmpresaService
    {
        Task<ResponseModel<EnterpriseTypeModel>> GetTipoDeEmpresaPorID(int id);
        Task<ResponseModel<List<EnterpriseTypeModel>>> ListarTiposDeEmpresa();
        Task<ResponseModel<EnterpriseTypeModel>> CriarTipoDeEmpresa(EnterpriseTypeCreateDto novoTipoDeEmpresa);
        Task<ResponseModel<List<EnterpriseTypeModel>>> DeletarTipoDeEmpresa(int id);
        Task<ResponseModel<EnterpriseTypeModel>> AtualizarTipoDeEmpresa(EnterpriseTypeModel tipoDeEmpresa);
    }
}
