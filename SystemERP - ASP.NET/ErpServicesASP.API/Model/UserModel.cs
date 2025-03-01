using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class UserModel
    {
        [Key]
        public int Id { get; set; }
        public string Name { get; set; }
        public string CPF { get; set; }
        public string Email { get; set; }
        public string Senha { get; set; }
        public DateTime DataCriacao { get; set; }
        public UserModel(string name, string CPF, string email, string senha)
        {
            Name = name;
            this.CPF = CPF;
            Email = email;
            DataCriacao = DateTime.Now;
            Senha = senha;
        }
    }
}
