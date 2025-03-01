using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface IEmpresaRepository
    {
        Task<EnterpriseModel> CriarEmpresa(EnterpriseCreateDto novaEmpresa);
        Task<EnterpriseModel> GetEmpresaPeloId(int id);
        Task<List<EnterpriseModel>> ListarEmpresas();
        Task<EnterpriseModel> AtualizarEmpresa(EnterpriseModel empresaAtualizada);
        Task<bool> empresaJaExiste(EnterpriseCreateDto novaEmpresa);
        Task<List<EnterpriseModel>> DeletarEmpresaPeloId(EnterpriseModel empresa);
        Task<bool> CnpjJaUsado(string cnpj);
        Task<bool> EmailJaUsado(string email);
    }
}
