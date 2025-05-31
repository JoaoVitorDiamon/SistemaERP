using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Services.Interfaces
{
    public interface ITokenInterface
    {
        public string GenerateToken(UserModel user);
    }
}
