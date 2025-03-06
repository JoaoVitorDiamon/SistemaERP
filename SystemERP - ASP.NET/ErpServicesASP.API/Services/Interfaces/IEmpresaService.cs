using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Services.Interfaces
{
    public interface IEmpresaService
    {
        Task<ResponseModel<EnterpriseModel>> CreateEnterprise(EnterpriseCreateDto novaEmpresa);
        Task<ResponseModel<EnterpriseModel>> GetEnterpriseById(int id);
        Task<ResponseModel<List<EnterpriseModel>>> ListEnterprises();
        Task<ResponseModel<EnterpriseModel>> UpdateEnterprise(EnterpriseModel empresaAtualizada);
        Task<ResponseModel<List<EnterpriseModel>>> DeleteEnterpriseByID(int id);
        Task<ResponseModel<string>> CheckIfCnpjUsed(string cnpj);
        Task<ResponseModel<string>> CheckIfEmailUsed(string email);
    }
}
