using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class AddressModel
    {
        [Key]
        public int idAddress { get; set; }
        public string country { get; set; }
        public string cep { get; set; }
        public string state { get; set; }
        public string city { get; set; }
        public string neighborhood { get; set; }
        public string street { get; set; }
        public string number { get; set; }
        public string complement { get; set; }
        public EmpresaModel Empresa { get; set; }
        public MembroModel Membro { get; set; }
    }
}
