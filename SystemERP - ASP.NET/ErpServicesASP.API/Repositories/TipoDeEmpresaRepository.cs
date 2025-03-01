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

        public async Task<EnterpriseTypeModel> AtualizarTipoDeEmpresa(EnterpriseTypeModel tipoDeEmpresa)
        {
            _context.EnterpriseType.Update(tipoDeEmpresa);
            await _context.SaveChangesAsync();
            return tipoDeEmpresa;
        }

        public async Task<EnterpriseTypeModel> CriarTipoDeEmpresa(EnterpriseTypeCreateDto novoTipoDeEmpresa)
        {
            var tipoDeEmpresa = new EnterpriseTypeModel() { Name = novoTipoDeEmpresa.Name};
            await _context.EnterpriseType.AddAsync(tipoDeEmpresa);
            await _context.SaveChangesAsync();
            return tipoDeEmpresa;
        }

        public async Task<List<EnterpriseTypeModel>> DeletarTipoDeEmpresa(EnterpriseTypeModel tipoDeEmpresa)
        {
            _context.EnterpriseType.Remove(tipoDeEmpresa);
            await _context.SaveChangesAsync();
            return await ListarTiposDeEmpresa();
        }

        public async Task<EnterpriseTypeModel> GetTipoDeEmpresaPorID(int id)
        {
            var tipoDeEmpresa = await _context.EnterpriseType.FindAsync(id);
            return tipoDeEmpresa;
        }

        public async Task<List<EnterpriseTypeModel>> ListarTiposDeEmpresa()
        {
            var lista = await _context.EnterpriseType.ToListAsync();
            return lista;
        }

        public async Task<bool> tipoJaExiste(string nomeTipoDeEmpresa)
        {
            var tipoExiste = await _context.EnterpriseType.FirstOrDefaultAsync(tipo => tipo.Name == nomeTipoDeEmpresa);
            if (tipoExiste == null)
                return false;
            return true;
        }
    }
}
