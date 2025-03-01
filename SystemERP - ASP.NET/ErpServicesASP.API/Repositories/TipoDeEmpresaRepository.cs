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
            _context.EnterpriseTypes.Update(tipoDeEmpresa);
            await _context.SaveChangesAsync();
            return tipoDeEmpresa;
        }

        public async Task<EnterpriseTypeModel> CriarTipoDeEmpresa(EnterpriseTypeCreateDto novoTipoDeEmpresa)
        {
            var tipoDeEmpresa = new EnterpriseTypeModel() { Name = novoTipoDeEmpresa.Name};
            await _context.EnterpriseTypes.AddAsync(tipoDeEmpresa);
            await _context.SaveChangesAsync();
            return tipoDeEmpresa;
        }

        public async Task<List<EnterpriseTypeModel>> DeletarTipoDeEmpresa(EnterpriseTypeModel tipoDeEmpresa)
        {
            _context.EnterpriseTypes.Remove(tipoDeEmpresa);
            await _context.SaveChangesAsync();
            return await ListarTiposDeEmpresa();
        }

        public async Task<EnterpriseTypeModel> GetTipoDeEmpresaPorID(int id)
        {
            var tipoDeEmpresa = await _context.EnterpriseTypes.FindAsync(id);
            return tipoDeEmpresa;
        }

        public async Task<List<EnterpriseTypeModel>> ListarTiposDeEmpresa()
        {
            var lista = await _context.EnterpriseTypes.ToListAsync();
            return lista;
        }

        public async Task<bool> tipoJaExiste(string nomeTipoDeEmpresa)
        {
            var tipoExiste = await _context.EnterpriseTypes.FirstOrDefaultAsync(tipo => tipo.Name == nomeTipoDeEmpresa);
            if (tipoExiste == null)
                return false;
            return true;
        }
    }
}
