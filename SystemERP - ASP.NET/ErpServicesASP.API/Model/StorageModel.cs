using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class StorageModel
    {
        [Key]
        public int id_armazem { get; set; }
        public string nome { get; set; }
        public string descricao { get; set; }
        public string telefone { get; set; }
    }
}
