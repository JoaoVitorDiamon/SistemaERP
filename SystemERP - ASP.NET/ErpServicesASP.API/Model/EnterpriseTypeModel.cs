using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class EnterpriseTypeModel
    {
        [Key]
        public int IdEnterpriseType { get; set; }
        public string Name { get; set; }
    }
}
