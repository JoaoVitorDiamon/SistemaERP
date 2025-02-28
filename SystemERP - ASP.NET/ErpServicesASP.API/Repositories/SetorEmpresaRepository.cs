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

        public async Task<SetorModel> AtualizarSetorEmpresa(SetorModel setor)
        {
            _context.Setores.Update(setor);
            await _context.SaveChangesAsync();
            return setor;
        }

        public async Task<SetorModel> CriarSetorEmpresa(SectorCreateDto novoSetor)
        {
            var setor = new SetorModel() { Nome = novoSetor.Nome};
            await _context.Setores.AddAsync(setor);
            await _context.SaveChangesAsync();
            return setor;
        }

        public async Task<List<SetorModel>> DeletarSetorEmpresa(SetorModel setor)
        {
            _context.Setores.Remove(setor);
            await _context.SaveChangesAsync();
            return await ListarSetoresEmpresa();
        }

        public async Task<SetorModel> GetSetorEmpresaPorID(int id)
        {
            var setor = await _context.Setores.FindAsync(id);
            return setor;
        }

        public async Task<List<SetorModel>> ListarSetoresEmpresa()
        {
            var lista = await _context.Setores.ToListAsync();
            return lista;
        }

        public async Task<bool> SetorEmpresaJaExiste(string nomeSetor)
        {
            var setorExiste = await _context.Setores.FirstOrDefaultAsync(setor => setor.Nome == nomeSetor);
            if (setorExiste == null)
                return false;
            return true;
        }
    }
}
