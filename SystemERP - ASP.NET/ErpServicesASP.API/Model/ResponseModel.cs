using Microsoft.AspNetCore.Http.HttpResults;

namespace ErpServicesASP.API.Model
{
    public class ResponseModel<T>
    {
        public T? Valor { get; set; }
        public string Mensagem { get; set; }
        public bool Status { get; set; } = true;

        public void setErro(string erro)
        {
            Mensagem = erro;
            Status = false;
        }
    }
}
