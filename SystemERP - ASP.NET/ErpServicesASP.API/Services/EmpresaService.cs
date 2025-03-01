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

        public Task<ResponseModel<EnterpriseModel>> AtualizarEmpresa(EnterpriseModel empresaAtualizada)
        {
            throw new NotImplementedException();
        }

        public async Task<ResponseModel<string>> CnpjJaUsado(string cnpj)
        {
            ResponseModel<string> response = new ResponseModel<string>();
            try
            {
                if(await _repository.CnpjJaUsado(cnpj))
                {
                    response.Valor = "Usado";
                    return response;
                }
                response.Valor = "Não usado";
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }
        public async Task<ResponseModel<string>> EmailJaUsado(string email)
        {
            ResponseModel<string> response = new ResponseModel<string>();
            try
            {
                if (await _repository.EmailJaUsado(email))
                {
                    response.Valor = "Usado";
                    return response;
                }
                response.Valor = "Não usado";
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<EnterpriseModel>> CriarEmpresa(EnterpriseCreateDto novaEmpresa)
        {
            ResponseModel<EnterpriseModel> response = new ResponseModel<EnterpriseModel>();
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

        public Task<ResponseModel<List<EnterpriseModel>>> DeletarEmpresaPeloId(int id)
        {
            throw new NotImplementedException();
        }

        public async Task<ResponseModel<EnterpriseModel>> GetEmpresaPeloId(int id)
        {
            ResponseModel<EnterpriseModel> response = new ResponseModel<EnterpriseModel>();
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

        public async Task<ResponseModel<List<EnterpriseModel>>> ListarEmpresas()
        {
            ResponseModel<List<EnterpriseModel>> response = new ResponseModel<List<EnterpriseModel>>();
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
