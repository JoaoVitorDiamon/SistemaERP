using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class AddressModel
    {
        [Key]
        public int IdAdress { get; set; }
        public string Country { get; set; }
        public string CEP { get; set; }
        public string State { get; set; }
        public string City { get; set; }
        public string Neighborhood { get; set; }
        public string Street { get; set; }
        public string Number { get; set; }
        public string Complement { get; set; }
        public EnterpriseModel Enterprise { get; set; }
        public ThirdPartiesModel Third { get; set; }
    }
}
