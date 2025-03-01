using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class ThirdPartiesModel
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int idTerceiros { get; set; }

        [MaxLength(255)]
        public string nome { get; set; }

        [MaxLength(255)]
        public string nomeEFantasia { get; set; }

        public bool fornecedor { get; set; }
        public bool estadoAtividade { get; set; }

        [EmailAddress]
        [MaxLength(255)]
        public string email { get; set; }

        public bool impostoSobVenda { get; set; }
        public bool segundoImposto { get; set; }

        [Column(TypeName = "decimal(18,2)")]
        public double capital { get; set; }

        public int quantidadeColaboradores { get; set; }

        [Column(TypeName = "bytea")]
        public byte[] logotipo { get; set; }
    }
}
