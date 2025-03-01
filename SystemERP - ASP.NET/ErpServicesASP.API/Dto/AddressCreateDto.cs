using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Dto
{
    public class AddressCreateDto
    {
        public string Country { get; set; }
        public string CEP { get; set; }
        public string State { get; set; }
        public string City { get; set; }
        public string Neighborhood { get; set; }
        public string Street { get; set; }
        public string Number { get; set; }
        public string Complement { get; set; }
        public int IdEnterprise { get; set; }
        public int IdThird { get; set; }
    }
}
