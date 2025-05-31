using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class ClientTypeModel
    {
        [Key]
        public int IdClientType { get; set; }
        public string Name { get; set; }
    }
}
