using ErpServicesASP.API.Data;
using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace ErpServicesASP.API.Repositories
{
    public class UsuarioRepository : IUsuarioRepository
    {
        private readonly AppDbContext _context;
        public UsuarioRepository(AppDbContext context) { _context = context; }
        public async Task<ResponseModel<UsuarioModel>> CriarUsuario(UsuarioCreateDto novoUsuario)
        {
            ResponseModel<UsuarioModel> response = new ResponseModel<UsuarioModel>();
            try
            {
                var usuarioExiste = UsuarioJaExiste(novoUsuario).Result;
                if (usuarioExiste)
                {
                    response.Mensagem = "Email ou CPF já cadastrados";
                    response.Status = false;
                    return response;
                }
                var usuario = new UsuarioModel(
                    novoUsuario.Name,
                    novoUsuario.CPF,
                    novoUsuario.Telefone,
                    novoUsuario.Email,
                    novoUsuario.Genero,
                    novoUsuario.Senha,
                    novoUsuario.CEP,
                    novoUsuario.Endereco,
                    novoUsuario.DataNascimento,
                    novoUsuario.AssociacaoPublica
                    );
                await _context.Usuarios.AddAsync(usuario);
                await _context.SaveChangesAsync();
                response.Valor = usuario;
                return response;
            }
            catch (Exception ex)
            {
                response.Mensagem = ex.Message;
                response.Status = false;
                return response;
            }
        }

        private async Task<bool> UsuarioJaExiste(UsuarioCreateDto novoUsuario)
        {
            var emailCadastrado = await _context.Usuarios.FirstOrDefaultAsync(usuario => novoUsuario.Email == usuario.Email);
            var cpfCadastrado = await _context.Usuarios.FirstOrDefaultAsync(usuario => novoUsuario.CPF == usuario.CPF);
            if(emailCadastrado != null && cpfCadastrado != null)
            {
                return true;
            }
            return false;
        }

        public Task<ResponseModel<List<UsuarioModel>>> DeletarUsuarioPorId(int id)
        {
            throw new NotImplementedException();
        }

        public Task<ResponseModel<UsuarioModel>> getUsuarioPorId(int id)
        {
            throw new NotImplementedException();
        }

        public async Task<ResponseModel<List<UsuarioModel>>> ListarUsuarios()
        {
            ResponseModel<List<UsuarioModel>> response = new ResponseModel<List<UsuarioModel>>();
            try
            {

                var lista = await _context.Usuarios.Join(
                    _context.ValidacoesDeEmails.Where(val => val.Validado == true),
                    usuario => usuario,
                    validacoes => validacoes.Usuario,
                    (usuario, validacoes) => usuario).ToListAsync();
                response.Valor = lista;
                return response;
            }
            catch(Exception ex)
            {
                response.Mensagem = ex.Message;
                response.Status = false;
                return response;
            }
        }
    }
}
