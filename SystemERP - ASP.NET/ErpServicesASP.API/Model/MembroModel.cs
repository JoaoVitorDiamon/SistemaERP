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
        public string EmailDaEmpresa { get; set; }
    }
}
