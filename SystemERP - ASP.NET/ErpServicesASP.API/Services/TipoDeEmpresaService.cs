using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Services.Interfaces;

namespace ErpServicesASP.API.Services
{
    public class TipoDeEmpresaService : ITipoDeEmpresaService
    {
        public Task<ResponseModel<TipoDeEmpresaModel>> AtualizarTipoDeEmpresa(TipoDeEmpresaModel tipoDeEmpresa)
        {
            throw new NotImplementedException();
        }

        public Task<ResponseModel<TipoDeEmpresaModel>> CriarTipoDeEmpresa(TipoDeEmpresaCreateDto novoTipoDeEmpresa)
        {
            throw new NotImplementedException();
        }

        public Task<ResponseModel<List<TipoDeEmpresaModel>>> DeletarTipoDeEmpresa(TipoDeEmpresaModel tipoDeEmpresa)
        {
            throw new NotImplementedException();
        }

        public Task<ResponseModel<TipoDeEmpresaModel>> GetTipoDeEmpresaPorID(int id)
        {
            throw new NotImplementedException();
        }

        public Task<ResponseModel<List<TipoDeEmpresaModel>>> ListarTiposDeEmpresa()
        {
            throw new NotImplementedException();
        }
    }
}
