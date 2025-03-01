using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ErpServicesASP.API.Model
{
    public class SectorModel
    {
        [Key]
        public int IdSector { get; set; }
        public string Name { get; set; }
    }
}
