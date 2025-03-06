using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface IMembroRepository
    {
        Task<MemberGetIdDto> GetMemberById(int membroId);
        Task<MemberModel> CreateMember(MemberCreateDto novoMembro, UserModel usuario, PositionModel cargo, EnterpriseModel empresa);
        Task<List<MemberGetIdDto>> ListMembers();
        Task<bool> CheckExistenceMember(MemberCreateDto novoMembro);
    }
}
