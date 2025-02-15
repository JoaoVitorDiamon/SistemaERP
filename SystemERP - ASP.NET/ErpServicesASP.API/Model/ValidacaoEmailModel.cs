using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Model
{
    public class ValidacaoEmailModel
    {
        public void GerarCodigo()
        {
            var code = new Random().Next(0, 9).ToString() + new Random().Next(0, 9).ToString() 
                + new Random().Next(0, 9).ToString() + new Random().Next(0, 9).ToString();
            Codigo = code;
        }

        [Key]
        public int idValidacaoEmail { get; set; }
        public string Codigo { get; set; }
        public UsuarioModel Usuario { get; set; }
        public bool Validado { get; set; } = false;
    }

}
