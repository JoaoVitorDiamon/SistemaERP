using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class MembroModel
    {
        [Key]
        public int idMembro { get; set; }
        public EmpresaModel Empresa { get; set; }
        public UsuarioModel Usuario { get; set; }
        public CargoModel Cargo { get; set; }
        public string NaturezaMembro { get; set; }
        public string Genero { get; set; }
        public string Telefone { get; set; }
        public string Senha { get; set; }
        public string CEP { get; set; }
        public DateTime DataNascimento { get; set; }
        public string AssociacaoPublica { get; set; }

        public void SalvarChaves(UsuarioModel usuario, EmpresaModel empresa, CargoModel cargo)
        {
            Empresa = empresa;
            Usuario = usuario;
            Cargo = cargo;
        }
    }
}
