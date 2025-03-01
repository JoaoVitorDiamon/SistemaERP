using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Dto
{
    public class TelephoneCreateDto
    {
        public string Number { get; set; }
        public int IdEnterprise { get; set; }
        public int IdThird { get; set; }
        public int IdMember { get; set; }
        public int IdStorage { get; set; }
    }
}
