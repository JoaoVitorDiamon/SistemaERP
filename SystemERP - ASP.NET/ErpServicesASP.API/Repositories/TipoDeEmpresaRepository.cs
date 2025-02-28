using ErpServicesASP.API.Data;
using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace ErpServicesASP.API.Repositories
{
    public class TipoDeEmpresaRepository : ITipoDeEmpresaRepository
    {
        private readonly AppDbContext _context;
        public TipoDeEmpresaRepository(AppDbContext context) { _context = context; }

        public async Task<TipoDeEmpresaModel> AtualizarTipoDeEmpresa(TipoDeEmpresaModel tipoDeEmpresa)
        {
            _context.TipoDeEmpresa.Update(tipoDeEmpresa);
            await _context.SaveChangesAsync();
            return tipoDeEmpresa;
        }

        public async Task<TipoDeEmpresaModel> CriarTipoDeEmpresa(EnterpriseTypeCreateDto novoTipoDeEmpresa)
        {
            var tipoDeEmpresa = new TipoDeEmpresaModel() { Name = novoTipoDeEmpresa.Name};
            await _context.TipoDeEmpresa.AddAsync(tipoDeEmpresa);
            await _context.SaveChangesAsync();
            return tipoDeEmpresa;
        }

        public async Task<List<TipoDeEmpresaModel>> DeletarTipoDeEmpresa(TipoDeEmpresaModel tipoDeEmpresa)
        {
            _context.TipoDeEmpresa.Remove(tipoDeEmpresa);
            await _context.SaveChangesAsync();
            return await ListarTiposDeEmpresa();
        }

        public async Task<TipoDeEmpresaModel> GetTipoDeEmpresaPorID(int id)
        {
            var tipoDeEmpresa = await _context.TipoDeEmpresa.FindAsync(id);
            return tipoDeEmpresa;
        }

        public async Task<List<TipoDeEmpresaModel>> ListarTiposDeEmpresa()
        {
            var lista = await _context.TipoDeEmpresa.ToListAsync();
            return lista;
        }

        public async Task<bool> tipoJaExiste(string nomeTipoDeEmpresa)
        {
            var tipoExiste = await _context.TipoDeEmpresa.FirstOrDefaultAsync(tipo => tipo.Name == nomeTipoDeEmpresa);
            if (tipoExiste == null)
                return false;
            return true;
        }
    }
}
