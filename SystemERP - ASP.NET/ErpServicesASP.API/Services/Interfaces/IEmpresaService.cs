using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Services.Interfaces
{
    public interface IEmpresaService
    {
        Task<ResponseModel<EnterpriseModel>> CriarEmpresa(EnterpriseCreateDto novaEmpresa);
        Task<ResponseModel<EnterpriseModel>> GetEmpresaPeloId(int id);
        Task<ResponseModel<List<EnterpriseModel>>> ListarEmpresas();
        Task<ResponseModel<EnterpriseModel>> AtualizarEmpresa(EnterpriseModel empresaAtualizada);
        Task<ResponseModel<List<EnterpriseModel>>> DeletarEmpresaPeloId(int id);
        Task<ResponseModel<string>> CnpjJaUsado(string cnpj);
        Task<ResponseModel<string>> EmailJaUsado(string email);
    }
}
