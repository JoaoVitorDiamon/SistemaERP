using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface IEmpresaRepository
    {
        Task<EmpresaModel> CriarEmpresa(EmpresaCreateDto novaEmpresa);
        Task<EmpresaModel> GetEmpresaPeloId(int id);
        Task<List<EmpresaModel>> ListarEmpresas();
        Task<EmpresaModel> AtualizarEmpresa(EmpresaModel empresaAtualizada);
        Task<bool> empresaJaExiste(EmpresaCreateDto novaEmpresa);
        Task<List<EmpresaModel>> DeletarEmpresaPeloId(EmpresaModel empresa);
        Task<bool> CnpjJaUsado(string cnpj);
        Task<bool> EmailJaUsado(string email);
    }
}
