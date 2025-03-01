using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class EnterpriseModel
    {
        [Key]
        public int IdEmpresa { get; set; }
        public string Name { get; set; }
        public string FantasyName { get; set; }
        public UserModel Owner { get; set; }
        public string CNPJ { get; set; }
        public string Email { get; set; }
        public EnterpriseTypeModel EnterpriseType { get; set; }
        public SectorModel Sector { get; set; }
        public DateTime CreationDate { get; set; }
    }
}
