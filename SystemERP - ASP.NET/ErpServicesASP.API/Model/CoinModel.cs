using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class CoinModel
    {
        [Key]
        public int id { get; set; }
        public string nome { get; set; }
    }
}
