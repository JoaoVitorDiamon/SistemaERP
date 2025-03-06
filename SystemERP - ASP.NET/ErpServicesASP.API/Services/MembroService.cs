using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services.Interfaces;
using Microsoft.IdentityModel.Tokens;
using System.Runtime.ConstrainedExecution;

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
        public async Task<ResponseModel<MemberModel>> CreateMember(MemberCreateDto novoMembro)
        {
            ResponseModel<MemberModel> response = new ResponseModel<MemberModel>();
                var jaExiste = await _repository.CheckExistenceMember(novoMembro);
                if (jaExiste)
                {
                    response.setErro("Usuário já é membro");
                    return response;
                }
                var usuario = await _usuarioRepository.GetUsuarioPorId(novoMembro.Usuario_idUsuario);
                if (usuario == null)
                {
                    response.setErro("Usuário não encontrado");
                    return response;
                }
                var cargo = await _cargoRepository.GetResponsePositionById(novoMembro.Cargo_idCargo);
                if (cargo.Valor == null)
                {
                    response.setErro("Cargo não encontrado");
                    return response;
                }
                var empresa = await _empresaRepository.GetEnterpriseById(novoMembro.Empresa_idEmpresa);
                if (empresa == null)
                {
                    response.setErro("Empresa não encontrado");
                    return response;
                }
                response.Valor = await _repository.CreateMember(novoMembro, usuario, cargo.Valor, empresa);
                return response;
        }

        public async Task<ResponseModel<MemberGetIdDto>> GetMemberById(int membroId)
        {
            ResponseModel<MemberGetIdDto> response = new ResponseModel<MemberGetIdDto>();
            try
            {
                var membro = await _repository.GetMemberById(membroId);
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

        public async Task<ResponseModel<List<MemberGetIdDto>>> ListMembers()
        {
            ResponseModel<List<MemberGetIdDto>> response = new ResponseModel<List<MemberGetIdDto>>();
            try
            {
                var lista = await _repository.ListMembers();
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
