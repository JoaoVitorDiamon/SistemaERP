using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class AddressModel
    {
        [Key]
        public int IdAdress { get; set; }
        public string Country { get; set; }
        public string ZipCode { get; set; }
        public string City { get; set; }
        public string Neighborhood { get; set; }
        public string Street { get; set; }
        public string Number { get; set; }
        public string Complement { get; set; }

        public AddressModel(string country, string zipCode, string city, string neighborhood, string street, string number, string complement)
        {
            Country = country;
            ZipCode = zipCode;
            City = city;
            Neighborhood = neighborhood;
            Street = street;
            Number = number;
            Complement = complement;
        }
    }
}
