using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ErpServicesASP.API.Model
{
    public class EnterpriseModel
    {
        [Key]
        public int IdEnterprise { get; set; }
        public string Name { get; set; }
        public string NameFantasy { get; set; }

        public string CNPJ { get; set; }
        public string Email { get; set; }
        public string? Telephone { get; set; }
        public DateTime CreationDate { get; set; }

        [ForeignKey("OwnerId")]
        public UserModel Owner { get; set; }

        [ForeignKey("idaddress")]
        public AddressModel Address { get; set; } 

        [ForeignKey("IdCompanyType")]
        public EnterpriseTypeModel CompanyType { get; set; }

        [ForeignKey("IdSector")]
        public SectorModel Sector { get; set; }

    }
}
