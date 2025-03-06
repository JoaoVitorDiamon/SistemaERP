using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface IEmpresaRepository
    {
        Task<EnterpriseModel> CreateEnterprise(EnterpriseCreateDto novaEmpresa);
        Task<EnterpriseModel> GetEnterpriseById(int id);
        Task<List<EnterpriseModel>> ListEnterprises();
        Task<EnterpriseModel> UpdateEnterprise(EnterpriseModel empresaAtualizada);
        Task<bool> CheckExistenceEnterprise(EnterpriseCreateDto novaEmpresa);
        Task<List<EnterpriseModel>> DeleteEnterpriseByID(EnterpriseModel empresa);
        Task<bool> CheckIfCnpjUsed(string cnpj);
        Task<bool> CheckIfEmailUsed(string email);
    }
}
