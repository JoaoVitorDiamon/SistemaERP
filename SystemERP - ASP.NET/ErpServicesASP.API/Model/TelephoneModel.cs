using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;

namespace ErpServicesASP.API.Model
{
    public class TelephoneModel
    {
        [Key]
        public int IdTelephone { get; set; }
        public string Number { get; set; }
        public EnterpriseModel Enterprise { get; set; }
        public ThirdPartiesModel Third { get; set; }
        public MemberModel Member { get; set; }
        public StorageModel Storage { get; set; }
    }
}
