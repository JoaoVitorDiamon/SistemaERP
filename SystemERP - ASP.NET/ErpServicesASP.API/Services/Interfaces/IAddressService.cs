using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Services.Interfaces
{
    public interface IAddressService
    {
        public Task<ResponseModel<AddressModel>> GetAdressById(int id);
        public Task<ResponseModel<AddressModel>> CreateAddress(AddressCreateDto newAdress);
    }
}
