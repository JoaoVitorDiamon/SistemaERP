using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services.Interfaces;

namespace ErpServicesASP.API.Services
{
    public class AddressService : IAddressService
    {
        private readonly IAddressRepository _repository;
        public AddressService(IAddressRepository repository) { _repository = repository; }
        public async Task<ResponseModel<AddressModel>> CreateAddress(AddressCreateDto newAdress)
        {
            ResponseModel<AddressModel> response = new ResponseModel<AddressModel>();
            try
            {
                var address = await _repository.CreateAddress(newAdress);
                response.Valor = address;
                return response;
            }
            catch (Exception ex)
            {
                response.setErro("Erro: " + ex.Message);
                return response;
            }
        }

        public async Task<ResponseModel<AddressModel>> GetAdressById(int id)
        {
            ResponseModel<AddressModel> response = new ResponseModel<AddressModel>();
            try
            {
                var address = await _repository.GetAdressById(id);
                if (address == null)
                {
                    response.setErro("Endereço não encontrado");
                }
                response.Valor = address;
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
