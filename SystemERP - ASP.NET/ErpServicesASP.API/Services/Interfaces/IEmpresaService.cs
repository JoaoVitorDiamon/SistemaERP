using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Services.Interfaces
{
    public interface IEmpresaService
    {
        Task<ResponseModel<EmpresaModel>> CriarEmpresa(EmpresaCreateDto novaEmpresa);
        Task<ResponseModel<EmpresaModel>> GetEmpresaPeloId(int id);
        Task<ResponseModel<List<EmpresaModel>>> ListarEmpresas();
        Task<ResponseModel<EmpresaModel>> AtualizarEmpresa(EmpresaModel empresaAtualizada);
        Task<ResponseModel<List<EmpresaModel>>> DeletarEmpresaPeloId(int id);
    }
}
