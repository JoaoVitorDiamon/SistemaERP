using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class UsuarioModel
    {
        [Key]
        public int Id { get; set; }
        public string Name { get; set; }
        public string CPF { get; set; }
        public string Telefone { get; set; }
        public string Email { get; set; }
        public string Genero { get; set; }
        public DateTime DataCriacao { get; set; }
        public string Senha { get; set; }
        public string CEP { get; set; }
        public string Endereco { get; set; }
        public DateTime DataNascimento { get; set; }
        public string AssociacaoPublica { get; set; }

        public UsuarioModel(string name, string CPF, string telefone, string email, string genero, string senha, string cEP, string endereco, DateTime dataNascimento, string associacaoPublica)
        {
            Name = name;
            this.CPF = CPF;
            Telefone = telefone;
            Email = email;
            Genero = genero;
            DataCriacao = DateTime.Now;
            Senha = senha;
            CEP = cEP;
            Endereco = endereco;
            DataNascimento = dataNascimento;
            AssociacaoPublica = associacaoPublica;
        }
    }
}
