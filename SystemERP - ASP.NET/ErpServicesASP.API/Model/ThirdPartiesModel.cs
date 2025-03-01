using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class ThirdPartiesModel
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int IdThirdParty { get; set; }
        public string Name { get; set; }
        public string TradeName { get; set; }
        public bool Supplier { get; set; }
        public bool ActivateState { get; set; }

        [EmailAddress]
        public string Email { get; set; }
        public bool TaxOnSales { get; set; }
        public bool SecondTax { get; set; }
        public double Capital { get; set; }
        public int EmployeeCount { get; set; }

        [Column(TypeName = "bytea")]
        public byte[] Logo { get; set; }

        [ForeignKey("EnterpriseId")]
        public EnterpriseModel enterprise { get; set; }

        [ForeignKey("IdCoin")]
        public CoinModel Coin { get; set; }

        [ForeignKey("IdAdress")]
        public AddressModel Address { get; set; }
    }
}
