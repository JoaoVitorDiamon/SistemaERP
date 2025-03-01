using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class CoinModel
    {
        [Key]
        public int IdCoin { get; set; }
        public string Name { get; set; }
    }
}
