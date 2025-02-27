using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class EmpresaModel
    {
        [Key]
        public int idEmpresa { get; set; }
        public string Name { get; set; }
        public string NomeFantasia { get; set; }
        public UsuarioModel Dono { get; set; }
        public string CNPJ { get; set; }
        public string Email { get; set; }
       public string Telefone { get; set; }
        public string Endereco { get; set; }
        public string CEP { get; set; }
        public TipoDeEmpresaModel TipoDeEmpresa { get; set; }
        public SetorModel Setor { get; set; }
        public DateTime DataCriacao { get; set; }
    }
}
