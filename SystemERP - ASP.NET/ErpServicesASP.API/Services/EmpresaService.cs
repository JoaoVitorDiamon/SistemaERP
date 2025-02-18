using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services.Interfaces;

namespace ErpServicesASP.API.Services
{
    public class EmpresaService : IEmpresaService
    {
        private readonly IEmpresaRepository _repository;
        public EmpresaService(IEmpresaRepository repository) { _repository = repository; }

        public Task<ResponseModel<EmpresaModel>> AtualizarEmpresa(EmpresaModel empresaAtualizada)
        {
            throw new NotImplementedException();
        }

        public async Task<ResponseModel<EmpresaModel>> CriarEmpresa(EmpresaCreateDto novaEmpresa)
        {
            ResponseModel<EmpresaModel> response = new ResponseModel<EmpresaModel>();
            try
            {
                if (await _repository.empresaJaExiste(novaEmpresa))
                {
                    response.setErro("Empresa já existe");
                    return response;
                }
                var empresa = await _repository.CriarEmpresa(novaEmpresa);
                response.Valor = empresa;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public Task<ResponseModel<List<EmpresaModel>>> DeletarEmpresaPeloId(int id)
        {
            throw new NotImplementedException();
        }

        public async Task<ResponseModel<EmpresaModel>> GetEmpresaPeloId(int id)
        {
            ResponseModel<EmpresaModel> response = new ResponseModel<EmpresaModel>();
            try
            {
                var empresa = await _repository.GetEmpresaPeloId(id);
                if (empresa == null)
                {
                    response.setErro("Empresa não encontrada");
                    return response;
                }
                response.Valor = empresa;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<List<EmpresaModel>>> ListarEmpresas()
        {
            ResponseModel<List<EmpresaModel>> response = new ResponseModel<List<EmpresaModel>>();
            try
            {
                response.Valor = await _repository.ListarEmpresas();
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }
    }
}
