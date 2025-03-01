using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ErpServicesASP.API.Model
{
    public class StorageModel
    {
        [Key]
        public int IdStorage { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public string Phone { get; set; }

        [ForeignKey("IdAdress")]
        public AddressModel Address { get; set; }

        [ForeignKey("IdEnterprise")]
        public EnterpriseModel Enterprise { get; set; }
    }
}
