using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class TipoDeEmpresaModel
    {
        [Key]
        public int idTipoDeEmpresa { get; set; }
        public string Name { get; set; }
    }
}
