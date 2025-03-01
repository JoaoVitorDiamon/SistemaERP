using ErpServicesASP.API.Data;
using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;

namespace ErpServicesASP.API.Repositories
{
    public class AddressRepository : IAddressRepository
    {
        private readonly AppDbContext _context;
        public AddressRepository(AppDbContext context) { _context = context; }

        public async Task<AddressModel> CreateAddress(AddressCreateDto newAdress)
        {
            var address = new AddressModel
            (
                newAdress.Country, newAdress.ZipCode, newAdress.City, newAdress.Neighborhood, newAdress.Street, newAdress.Number, newAdress.Complement
            );
            await _context.Adress.AddAsync(address);
            await _context.SaveChangesAsync();
            return address;
        }

        public async Task<AddressModel> GetAdressById(int id)
        {
            var address = await _context.Adress.FindAsync(id);
            return address;
        }
    }
}
