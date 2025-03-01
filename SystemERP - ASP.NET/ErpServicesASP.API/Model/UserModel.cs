using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class UserModel
    {
        [Key]
        public int IdUser { get; set; }
        public string Name { get; set; }
        public string CPF { get; set; }
        public string Email { get; set; }
        public string Password { get; set; }
        public DateTime CreationDate { get; set; }
        public UserModel(string name, string CPF, string email, string password)
        {
            Name = name;
            this.CPF = CPF;
            Email = email;
            CreationDate = DateTime.Now;
            Password = password;
        }
    }
}
