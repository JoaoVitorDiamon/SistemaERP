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

        public Task<ResponseModel<EnterpriseModel>> UpdateEnterprise(EnterpriseModel empresaAtualizada)
        {
            throw new NotImplementedException();
        }

        public async Task<ResponseModel<string>> CheckIfCnpjUsed(string cnpj)
        {
            ResponseModel<string> response = new ResponseModel<string>();
            try
            {
                if(await _repository.CheckIfCnpjUsed(cnpj))
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
        public async Task<ResponseModel<string>> CheckIfEmailUsed(string email)
        {
            ResponseModel<string> response = new ResponseModel<string>();
            try
            {
                if (await _repository.CheckIfEmailUsed(email))
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

        public async Task<ResponseModel<EnterpriseModel>> CreateEnterprise(EnterpriseCreateDto novaEmpresa)
        {
            ResponseModel<EnterpriseModel> response = new ResponseModel<EnterpriseModel>();
            try
            {
                if (await _repository.CheckExistenceEnterprise(novaEmpresa))
                {
                    response.setErro("Empresa já existe");
                    return response;
                }
                var empresa = await _repository.CreateEnterprise(novaEmpresa);
                response.Valor = empresa;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public Task<ResponseModel<List<EnterpriseModel>>> DeleteEnterpriseByID(int id)
        {
            throw new NotImplementedException();
        }

        public async Task<ResponseModel<EnterpriseModel>> GetEnterpriseById(int id)
        {
            ResponseModel<EnterpriseModel> response = new ResponseModel<EnterpriseModel>();
            try
            {
                var empresa = await _repository.GetEnterpriseById(id);
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

        public async Task<ResponseModel<List<EnterpriseModel>>> ListEnterprises()
        {
            ResponseModel<List<EnterpriseModel>> response = new ResponseModel<List<EnterpriseModel>>();
            try
            {
                response.Valor = await _repository.ListEnterprises();
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
