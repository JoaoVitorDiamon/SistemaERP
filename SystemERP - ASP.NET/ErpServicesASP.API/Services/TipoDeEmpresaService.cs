using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services.Interfaces;

namespace ErpServicesASP.API.Services
{
    public class TipoDeEmpresaService : ITipoDeEmpresaService
    {
        private readonly ITipoDeEmpresaRepository _repository;
        public TipoDeEmpresaService(ITipoDeEmpresaRepository repository) { _repository = repository; }
        public async Task<ResponseModel<TipoDeEmpresaModel>> AtualizarTipoDeEmpresa(TipoDeEmpresaModel tipoDeEmpresa)
        {
            ResponseModel<TipoDeEmpresaModel> response = new ResponseModel<TipoDeEmpresaModel>();
            try
            {
                var tipoDeEmpresaNoBanco = await _repository.GetTipoDeEmpresaPorID(tipoDeEmpresa.idTipoDeEmpresa);
                if(tipoDeEmpresaNoBanco == null) 
                {
                    response.setErro("Tipo de empresa não existe");
                    return response;
                }
                tipoDeEmpresaNoBanco.Name = tipoDeEmpresa.Name;
                var update = await _repository.AtualizarTipoDeEmpresa(tipoDeEmpresaNoBanco);
                response.Valor = update;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<TipoDeEmpresaModel>> CriarTipoDeEmpresa(EnterpriseTypeCreateDto novoTipoDeEmpresa)
        {
            ResponseModel<TipoDeEmpresaModel> response = new ResponseModel<TipoDeEmpresaModel>();
            try
            {
                var tipoDeEmpresaExiste = await _repository.tipoJaExiste(novoTipoDeEmpresa.Name);
                if (tipoDeEmpresaExiste)
                {
                    response.setErro("Tipo de empresa já existe");
                    return response;
                }
                var tipoDeEmpresa = await _repository.CriarTipoDeEmpresa(novoTipoDeEmpresa);
                if (tipoDeEmpresa == null)
                {
                    response.setErro("Não foi possível criar o tipo de empresa");
                    return response;
                }
                response.Valor = tipoDeEmpresa;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<List<TipoDeEmpresaModel>>> DeletarTipoDeEmpresa(int id)
        {
            ResponseModel<List<TipoDeEmpresaModel>> response = new ResponseModel<List<TipoDeEmpresaModel>>();
            try
            {
                var tipoDeEmpresa = await _repository.GetTipoDeEmpresaPorID(id);
                var lista = await _repository.DeletarTipoDeEmpresa(tipoDeEmpresa);
                response.Valor = lista;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<TipoDeEmpresaModel>> GetTipoDeEmpresaPorID(int id)
        {
            ResponseModel<TipoDeEmpresaModel> response = new ResponseModel<TipoDeEmpresaModel>();
            try
            {
                var tipoDeEmpresa = await _repository.GetTipoDeEmpresaPorID(id);
                if(tipoDeEmpresa == null)
                {
                    response.setErro("Tipo de empresa não existe");
                    return response;
                }
                response.Valor = tipoDeEmpresa;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<List<TipoDeEmpresaModel>>> ListarTiposDeEmpresa()
        {
            ResponseModel<List<TipoDeEmpresaModel>> response = new ResponseModel<List<TipoDeEmpresaModel>>();
            try
            {
                var lista = await _repository.ListarTiposDeEmpresa();
                response.Valor = lista;
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
