using ErpServicesASP.API.Data;
using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services;
using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations;

namespace ErpServicesASP.API.Repositories
{
    public class ValidacaoEmailRepository : IValidacaoEmailRepository
    {
        private readonly AppDbContext _context;
        public ValidacaoEmailRepository(AppDbContext context)
        {
            _context = context;
        }

        public async Task<ValidacaoEmailModel> BuscarValidacaoPorEmail(string email)
        {
            var validacao = await _context.ValidacoesDeEmails.Join(
                _context.Usuarios.Where(usuario => usuario.Email == email),
                validacoes => validacoes.Usuario,
                usuario => usuario,
                (validacoes, usuario) => validacoes).FirstOrDefaultAsync();
            return validacao;
        }

        public async Task<ValidacaoEmailModel> CriarValidacao(UsuarioModel usuario)
        {
            var novaValidacao = new ValidacaoEmailModel() { Usuario = usuario };
            novaValidacao.GerarCodigo();
            await _context.ValidacoesDeEmails.AddAsync(novaValidacao);
            await _context.SaveChangesAsync();
            return novaValidacao;
        }

        public async Task<bool> ValidacaoJaEnviada(UsuarioModel usuario)
        {
            var validacaoEnviada = await _context.ValidacoesDeEmails.FirstOrDefaultAsync(val => val.Usuario == usuario);
            if (validacaoEnviada == null)
                return false;
            return true;
        }

        public async Task<ValidacaoEmailModel> ValidarEmail(ValidacaoEmailModel validacao)
        {
            validacao.Validado = true;
            _context.ValidacoesDeEmails.Update(validacao);
            await _context.SaveChangesAsync();
            return validacao;
        }
    }
}
