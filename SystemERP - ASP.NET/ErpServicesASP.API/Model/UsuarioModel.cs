using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class UsuarioModel
    {
        [Key]
        public int Id { get; set; }
        public string Name { get; set; }
        public string CPF { get; set; }
        public string Email { get; set; }
        public DateTime DataCriacao { get; set; }
        public UsuarioModel(string name, string CPF, string email)
        {
            Name = name;
            this.CPF = CPF;
            Email = email;
            DataCriacao = DateTime.Now;
        }
    }
}
