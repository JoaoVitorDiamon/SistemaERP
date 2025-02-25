using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class SetorModel
    {
        [Key]
        public int idSetor { get; set; }
        public string Nome { get; set; }
    }
}
