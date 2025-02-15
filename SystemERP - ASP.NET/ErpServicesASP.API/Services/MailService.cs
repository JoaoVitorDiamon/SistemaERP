using System.Net;
using System.Net.Mail;

namespace ErpServicesASP.API.Services
{
    public class MailService
    {
        private string smtpEndereco = "smtp.gmail.com";
        private int portNum = 587;
        private string emailDoERP = "hauleksm@gmail.com";
        private string senha = "mnye ncte puge xgkn";

        public void EnviarEmail(string emailDestinatario, string assunto, string texto, bool isHtml = false)
        {
            using (MailMessage mail = new MailMessage())
            {
                mail.From = new MailAddress(emailDoERP);
                mail.To.Add(emailDestinatario);
                mail.Subject = assunto;
                mail.Body = texto;
                mail.IsBodyHtml = isHtml;
                using (SmtpClient smtp = new SmtpClient(smtpEndereco, portNum))
                {
                    smtp.EnableSsl = true;
                    smtp.UseDefaultCredentials = false;
                    smtp.Credentials = new NetworkCredential(emailDoERP, senha);
                    smtp.Send(mail);
                }
            };
        }
    }
}
