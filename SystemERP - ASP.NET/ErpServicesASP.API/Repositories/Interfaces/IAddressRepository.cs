using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface IAddressRepository
    {
        public Task<AddressModel> GetAdressById(int id);
        public Task<AddressModel> CreateAddress(AddressCreateDto newAdress);
    }
}
