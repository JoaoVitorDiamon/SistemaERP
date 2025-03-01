using ErpServicesASP.API.Data;
using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace ErpServicesASP.API.Repositories
{
    public class SetorEmpresaRepository : ISetorEmpresaRepository
    {
        private readonly AppDbContext _context;
        public SetorEmpresaRepository(AppDbContext context) { _context = context; }

        public async Task<SectorModel> AtualizarSetorEmpresa(SectorModel setor)
        {
            _context.Sectors.Update(setor);
            await _context.SaveChangesAsync();
            return setor;
        }

        public async Task<SectorModel> CriarSetorEmpresa(SectorCreateDto novoSetor)
        {
            var setor = new SectorModel() { Nome = novoSetor.Nome};
            await _context.Sectors.AddAsync(setor);
            await _context.SaveChangesAsync();
            return setor;
        }

        public async Task<List<SectorModel>> DeletarSetorEmpresa(SectorModel setor)
        {
            _context.Sectors.Remove(setor);
            await _context.SaveChangesAsync();
            return await ListarSetoresEmpresa();
        }

        public async Task<SectorModel> GetSetorEmpresaPorID(int id)
        {
            var setor = await _context.Sectors.FindAsync(id);
            return setor;
        }

        public async Task<List<SectorModel>> ListarSetoresEmpresa()
        {
            var lista = await _context.Sectors.ToListAsync();
            return lista;
        }

        public async Task<bool> SetorEmpresaJaExiste(string nomeSetor)
        {
            var setorExiste = await _context.Sectors.FirstOrDefaultAsync(setor => setor.Nome == nomeSetor);
            if (setorExiste == null)
                return false;
            return true;
        }
    }
}
