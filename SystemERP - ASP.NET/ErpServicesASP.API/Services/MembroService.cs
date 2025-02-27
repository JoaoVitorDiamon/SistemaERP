using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services.Interfaces;
using Microsoft.IdentityModel.Tokens;

namespace ErpServicesASP.API.Services
{
    public class MembroService : IMembroService
    {
        private readonly IMembroRepository _repository;
        private readonly IUsuarioRepository _usuarioRepository;
        private readonly IEmpresaRepository _empresaRepository;
        private readonly ICargoRepository _cargoRepository;
        public MembroService(IMembroRepository repository, IUsuarioRepository usuarioRepository, IEmpresaRepository empresaRepository, ICargoRepository cargoRepository)
        {
            _repository = repository;
            _cargoRepository = cargoRepository;
            _empresaRepository = empresaRepository;
            _usuarioRepository = usuarioRepository;
        }
        public async Task<ResponseModel<MembroModel>> CriarMembro(MembroCreateDto novoMembro)
        {
            ResponseModel<MembroModel> response = new ResponseModel<MembroModel>();
            try
            {
                var jaExiste = await _repository.MembroJaExiste(novoMembro);
                if (jaExiste)
                {
                    response.setErro("Usuário já é membro");
                    return response;
                }
                response = await RastrearChavesEstrangeiras(response, novoMembro);
                if (!response.Mensagem.IsNullOrEmpty()) return response;
                await _repository.CriarMembro(response.Valor);
                return response;
            }
            catch(Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        private async Task<ResponseModel<MembroModel>> RastrearChavesEstrangeiras(ResponseModel<MembroModel> response, MembroCreateDto novoMembro)
        {
            var usuario = await _usuarioRepository.GetUsuarioPorId(novoMembro.Usuario_idUsuario);
            if (usuario == null)
            {
                response.setErro("Usuário não encontrado");
                return response;
            }
            var cargo = await _cargoRepository.GetCargoPorId(novoMembro.Cargo_idCargo);
            if (cargo.Valor == null)
            {
                response.setErro("Cargo não encontrado");
                return response;
            }
            var empresa = await _empresaRepository.GetEmpresaPeloId(novoMembro.Empresa_idEmpresa);
            if (empresa == null)
            {
                response.setErro("Empresa não encontrado");
                return response;
            }
            response.Valor = new MembroModel() {
                NaturezaMembro = novoMembro.NaturezaMembro,
                Telefone = novoMembro.Telefone,
                Genero = novoMembro.Genero,
                CEP = novoMembro.CEP,
                DataNascimento = novoMembro.DataNascimento,
                AssociacaoPublica = novoMembro.AssociacaoPublica
            };
            response.Valor.SalvarChaves(usuario, empresa, cargo.Valor);
            return response;
        }

        public async Task<ResponseModel<MembroGetIdDto>> GetMembroPorId(int membroId)
        {
            ResponseModel<MembroGetIdDto> response = new ResponseModel<MembroGetIdDto>();
            try
            {
                var membro = await _repository.GetMembroPorId(membroId);
                if(membro == null)
                {
                    response.setErro("Membro não encontrado");
                    return response;
                }
                response.Valor = membro;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<List<MembroGetIdDto>>> ListarMembros()
        {
            ResponseModel<List<MembroGetIdDto>> response = new ResponseModel<List<MembroGetIdDto>>();
            try
            {
                var lista = await _repository.ListarMembros();
                response.Valor = lista;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " +  ex.Message);
                return response;
            }
        }
    }
}
