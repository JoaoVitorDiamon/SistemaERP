using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class PositionModel
    {
        [Key]
        public int IdPosition { get; set; }
        public string Name { get; set; }
    }
}
