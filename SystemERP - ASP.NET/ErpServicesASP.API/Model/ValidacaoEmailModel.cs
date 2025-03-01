using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class ValidacaoEmailModel
    {
        public void GerarCodigo()
        {
            var code = new Random().Next(0, 9).ToString() + new Random().Next(0, 9).ToString() 
                + new Random().Next(0, 9).ToString() + new Random().Next(0, 9).ToString();
            Code = code;
        }

        [Key]
        public int IdValidacaoEmail { get; set; }
        public string Code { get; set; }
        public UserModel User { get; set; }
        public bool Validate { get; set; } = false;
    }

}
