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
        public async Task<UserModel?> CriarUsuario(UsuarioCreateDto novoUsuario)
        {
            var usuario = new UserModel(
                novoUsuario.Name,
                novoUsuario.CPF,
                novoUsuario.Email,
                novoUsuario.Senha
                );
            await _context.Users.AddAsync(usuario);
            await _context.SaveChangesAsync();
            return usuario;
        }

        public async Task<bool> UsuarioJaExiste(UsuarioCreateDto novoUsuario)
        {
            var emailCadastrado = await _context.Users.FirstOrDefaultAsync(usuario => novoUsuario.Email == usuario.Email);
            var cpfCadastrado = await _context.Users.FirstOrDefaultAsync(usuario => novoUsuario.CPF == usuario.CPF);
            if (emailCadastrado != null || cpfCadastrado != null)
            {
                return true;
            }
            return false;
        }

        public async Task<List<UserModel>> DeletarUsuario(UserModel usuario)
        {
            _context.Remove(usuario);
            await _context.SaveChangesAsync();
            return await ListarUsuarios();
        }

        public async Task<UserModel?> GetUsuarioPorId(int id)
        {
            var usuario = await _context.Users.FindAsync(id);
            return usuario;
        }

        public async Task<List<UserModel>> ListarUsuarios()
        {
            var lista = await _context.Users.ToListAsync();
            return lista;
        }

        public async Task<bool> VerificarExistenciaCPF(string cpf)
        {
            var cpfCadastrado = await _context.Users.FirstOrDefaultAsync(usuario => usuario.CPF == cpf);
            if (cpfCadastrado != null) return true;
            return false;
        }

        public async Task<bool> VerificarExistenciaEmail(string email)
        {
            var emailCadastrado = await _context.Users.FirstOrDefaultAsync(usuario => email == usuario.Email);
            if (emailCadastrado != null) return true;
            return false;
        }

        public async Task<UserModel?> LoginUser(string email, string password)
        {
            var usuario = await _context.Users.FirstOrDefaultAsync(u => u.Email == email && u.Password == password);
            return usuario;
        }
    }
}