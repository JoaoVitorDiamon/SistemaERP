using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Dto
{
    public class EnterpriseCreateDto
    {
        public string Name { get; set; }
        public string FantasyName { get; set; }
        public int IdOwner { get; set; }
        public string CNPJ { get; set; }
        public string Email { get; set; }
        public int IdAddress { get; set; }
        public int IdEnterpriseType { get; set; }
        public int IdSector { get; set; }
        public DateTime CreationDate { get; set; }
    }
}
