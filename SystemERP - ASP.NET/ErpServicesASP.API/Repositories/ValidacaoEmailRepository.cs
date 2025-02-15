using ErpServicesASP.API.Data;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services;
using Microsoft.EntityFrameworkCore;

namespace ErpServicesASP.API.Repositories
{
    public class ValidacaoEmailRepository : IValidacaoEmailRepository
    {
        private readonly AppDbContext _context;
        private readonly MailService _mailService;
        public ValidacaoEmailRepository(AppDbContext context, MailService mailService)
        {
            _context = context; _mailService = mailService;
        }
        public async Task<ResponseModel<string>> EnviarEmailValidacao(UsuarioModel usuario)
        {
            try
            {
                if (ValidacaoJaEnviada(usuario).Result)
                    return new ResponseModel<string>() { Mensagem = "Erro ao enviar", Status = false };
                var validacao = new ValidacaoEmailModel() { Usuario = usuario };
                validacao.GerarCodigo();
                await _context.ValidacoesDeEmails.AddAsync(validacao);
                await _context.SaveChangesAsync();
                _mailService.EnviarEmail(usuario.Email, "SISTEMA ERP - VERIFICAÇÃO", "Código: " + validacao.Codigo);
                return new ResponseModel<string>() { Mensagem = "sucesso" };
            }
            catch(Exception ex)
            {
                return new ResponseModel<string>() { Mensagem = "Erro ao enviar", Status = false };
            }
        }

        public async Task<bool> ValidacaoJaEnviada(UsuarioModel usuario)
        {
            var validacaoEnviada = await _context.ValidacoesDeEmails.FirstOrDefaultAsync(val => val.Usuario == usuario);
            if (validacaoEnviada == null)
                return false;
            return true;
        }

        public async Task<ResponseModel<string>> ValidarEmail(string email, string codigo)
        {
            var usuario = await _context.ValidacoesDeEmails.Join(
                _context.Usuarios.Where(usuario => usuario.Email == email),
                validacoes => validacoes.Usuario,
                usuario => usuario,
                (validacoes, usuario) => validacoes).FirstOrDefaultAsync();
            if(usuario == null)
            {
                return new ResponseModel<string>() { Mensagem = "erro", Status = false };
            }
            if (usuario.Codigo == codigo)
            {
                usuario.Validado = true;
                _context.ValidacoesDeEmails.Update(usuario);
                await _context.SaveChangesAsync();
                return new ResponseModel<string>() { Mensagem = "Sucesso"};
            }
            return new ResponseModel<string>() { Mensagem = "Codigo errado", Status = false };

        }
    }
}
