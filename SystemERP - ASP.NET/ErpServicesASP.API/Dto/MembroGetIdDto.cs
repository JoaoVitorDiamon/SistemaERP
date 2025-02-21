using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Dto
{
    public class MembroGetIdDto
    {
        [Key]
        public int idMembro { get; set; }
        public int Empresa_idEmpresa { get; set; }
        public int Usuario_idUsuario { get; set; }
        public int Cargo_idCargo { get; set; }
        public string NaturezaMembro { get; set; }
        public string EmailDaEmpresa { get; set; }
    }
}
