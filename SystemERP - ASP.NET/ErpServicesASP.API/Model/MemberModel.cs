using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ErpServicesASP.API.Model
{
    public class MemberModel
    {
        [Key]
        public int IdMembers { get; set; }
        public string NatureMember { get; set; }
        public string Gender { get; set; }
        public string ZipCode { get; set; }
        public string DateOfBirth { get; set; }
        public string Telephone { get; set; }
        public string PublicAssociation { get; set; }

        [ForeignKey("identerprise")]
        public EnterpriseModel Enterprise { get; set; }

        [ForeignKey("IdPosition")]
        public PositionModel Position { get; set; }

        [ForeignKey("iduser")]
        public UserModel User { get; set; }
    }
}
