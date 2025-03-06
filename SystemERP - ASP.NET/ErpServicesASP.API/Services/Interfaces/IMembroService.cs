using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Services.Interfaces
{
    public interface IMembroService
    {
        Task<ResponseModel<MemberGetIdDto>> GetMemberById(int membroId);
        Task<ResponseModel<MemberModel>> CreateMember(MemberCreateDto novoMembro);
        Task<ResponseModel<List<MemberGetIdDto>>> ListMembers();
    }
}
