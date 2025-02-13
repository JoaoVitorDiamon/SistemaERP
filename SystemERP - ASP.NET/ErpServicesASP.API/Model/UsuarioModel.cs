using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class UsuarioModel
    {
        [Key]
        public int Id { get; set; }
        public string Name { get; set; }
        private string CPF { get; set; }
        public string Telefone { get; set; }
        public string Email { get; set; }
        public string Genero { get; set; }
        public DateOnly DataCriacao { get; set; }
        private string Senha { get; set; }
        public string CEP { get; set; }
        public string Endereco { get; set; }
        public DateOnly DataNascimento { get; set; }
        public string AssociacaoPublica { get; set; }
    }
}
