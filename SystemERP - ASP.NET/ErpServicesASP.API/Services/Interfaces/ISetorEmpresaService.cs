using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Services.Interfaces
{
    public interface ISetorEmpresaService
    {
        Task<ResponseModel<SetorModel>> GetSetorEmpresaPorID(int id);
        Task<ResponseModel<List<SetorModel>>> ListarSetoresEmpresa();
        Task<ResponseModel<SetorModel>> CriarSetorEmpresa(SetorCreateDto novoSetor);
        Task<ResponseModel<List<SetorModel>>> DeletarSetorEmpresa(int id);
        Task<ResponseModel<SetorModel>> AtualizarSetorEmpresa(SetorModel setor);
    }
}
