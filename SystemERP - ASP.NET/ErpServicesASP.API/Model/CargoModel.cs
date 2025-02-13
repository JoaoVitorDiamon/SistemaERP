using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class CargoModel
    {
        [Key]
        public int idCargo { get; set; }
        public string Name { get; set; }
    }
}
