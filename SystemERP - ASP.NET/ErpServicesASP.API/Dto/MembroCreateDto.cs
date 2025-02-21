using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Dto
{
    public class MembroCreateDto
    {
        public int Empresa_idEmpresa { get; set; }
        public int Usuario_idUsuario { get; set; }
        public int Cargo_idCargo { get; set; }
        public string NaturezaMembro { get; set; }
        public string EmailDaEmpresa { get; set; }
    }
}
