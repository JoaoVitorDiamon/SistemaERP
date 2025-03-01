using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class MemberModel
    {
        [Key]
        public int IdMember { get; set; }
        public EnterpriseModel Empresa { get; set; }
        public UserModel Usuario { get; set; }
        public CargoModel Cargo { get; set; }
        public string NaturezaMembro { get; set; }
        public string Genero { get; set; }
        public AddressModel Address { get; set; }
        public DateTime DataNascimento { get; set; }
        public string AssociacaoPublica { get; set; }
    }
}
