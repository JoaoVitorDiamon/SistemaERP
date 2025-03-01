using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Dto
{
    public class MemberCreateDto
    {
        public int Empresa_idEmpresa { get; set; }
        public int Usuario_idUsuario { get; set; }
        public int Cargo_idCargo { get; set; }
        public string NatureMember { get; set; }
        public string Gender { get; set; }
        public string ZipCode { get; set; }
        public string DateOfBirth { get; set; }
        public string Telephone { get; set; }
        public string PublicAssociation { get; set; }
    }
}
