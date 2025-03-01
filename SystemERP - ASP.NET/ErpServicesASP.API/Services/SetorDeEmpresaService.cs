using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services.Interfaces;

namespace ErpServicesASP.API.Services
{
    public class SetorDeEmpresaService : ISetorEmpresaService
    {
        private readonly ISetorEmpresaRepository _repository;
        public SetorDeEmpresaService(ISetorEmpresaRepository repository) { _repository = repository; }
        public async Task<ResponseModel<SectorModel>> AtualizarSetorEmpresa(SectorModel setor)
        {
            ResponseModel<SectorModel> response = new ResponseModel<SectorModel>();
            try
            {
                var setorNoBanco = await _repository.GetSetorEmpresaPorID(setor.idSetor);
                if(setorNoBanco == null) 
                {
                    response.setErro("Tipo de empresa não existe");
                    return response;
                }
                setorNoBanco.Nome = setor.Nome;
                var update = await _repository.AtualizarSetorEmpresa(setorNoBanco);
                response.Valor = update;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<SectorModel>> CriarSetorEmpresa(SectorCreateDto novoSetor)
        {
            ResponseModel<SectorModel> response = new ResponseModel<SectorModel>();
            try
            {
                var setorExiste = await _repository.SetorEmpresaJaExiste(novoSetor.Nome);
                if (setorExiste)
                {
                    response.setErro("Tipo de empresa já existe");
                    return response;
                }
                var setor = await _repository.CriarSetorEmpresa(novoSetor);
                if (setor == null)
                {
                    response.setErro("Não foi possível criar o tipo de empresa");
                    return response;
                }
                response.Valor = setor;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<List<SectorModel>>> DeletarSetorEmpresa(int id)
        {
            ResponseModel<List<SectorModel>> response = new ResponseModel<List<SectorModel>>();
            try
            {
                var setor = await _repository.GetSetorEmpresaPorID(id);
                var lista = await _repository.DeletarSetorEmpresa(setor);
                response.Valor = lista;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<SectorModel>> GetSetorEmpresaPorID(int id)
        {
            ResponseModel<SectorModel> response = new ResponseModel<SectorModel>();
            try
            {
                var setor = await _repository.GetSetorEmpresaPorID(id);
                if(setor == null)
                {
                    response.setErro("Tipo de empresa não existe");
                    return response;
                }
                response.Valor = setor;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<List<SectorModel>>> ListarSetoresEmpresa()
        {
            ResponseModel<List<SectorModel>> response = new ResponseModel<List<SectorModel>>();
            try
            {
                var lista = await _repository.ListarSetoresEmpresa();
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
