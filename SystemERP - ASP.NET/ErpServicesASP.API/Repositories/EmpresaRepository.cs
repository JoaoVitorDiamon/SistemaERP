using ErpServicesASP.API.Data;
using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace ErpServicesASP.API.Repositories
{
    public class EmpresaRepository : IEmpresaRepository
    {
        private readonly AppDbContext _context;
        public EmpresaRepository(AppDbContext context) { _context = context; }
        public Task<EnterpriseModel> AtualizarEmpresa(EnterpriseModel empresaAtualizada)
        {
            throw new NotImplementedException();
        }

        public async Task<bool> CnpjJaUsado(string cnpj)
        {
            var cnpjJaExiste = await _context.Enterprises.FirstOrDefaultAsync(empresa => empresa.CNPJ == cnpj);
            if (cnpjJaExiste != null) return true;
            return false;
        }
        public async Task<bool> EmailJaUsado(string email)
        {
            var emailUsado = await _context.Enterprises.FirstOrDefaultAsync(empresa => empresa.Email == email);
            if (emailUsado != null) return true;
            return false;
        }

        public async Task<EnterpriseModel> CriarEmpresa(EnterpriseCreateDto novaEmpresa)
        {
            var owner = await _context.Users.FindAsync(novaEmpresa.IdOwner);
            var tipoEmpresa = await _context.EnterpriseTypes.FindAsync(novaEmpresa.IdEnterpriseType);
            var setor = await _context.Sectors.FindAsync(novaEmpresa.IdSector);
            EnterpriseModel empresa = new EnterpriseModel()
            {
                Name = novaEmpresa.Name,
                FantasyName = novaEmpresa.FantasyName,
                Owner = owner,
                CNPJ = novaEmpresa.CNPJ,
                Email = novaEmpresa.Email,
                EnterpriseType = tipoEmpresa,
                Sector = setor,
                CreationDate = novaEmpresa.CreationDate
            };
            await _context.Enterprises.AddAsync(empresa);
            await _context.SaveChangesAsync();
            return empresa;
        }

        public async Task<List<EnterpriseModel>> DeletarEmpresaPeloId(EnterpriseModel empresa)
        {
            _context.Enterprises.Remove(empresa);
            await _context.SaveChangesAsync();
            return await ListarEmpresas();
        }

        public async Task<bool> empresaJaExiste(EnterpriseCreateDto novaEmpresa)
        {
            var cnpjJaExiste = await _context.Enterprises.FirstOrDefaultAsync(empresa => empresa.CNPJ == novaEmpresa.CNPJ);
            if (cnpjJaExiste != null) return true;
            var email = await _context.Enterprises.FirstOrDefaultAsync(empresa => empresa.Email == novaEmpresa.Email);
            if (email != null) return true;
            return false;

        }

        public async Task<EnterpriseModel> GetEmpresaPeloId(int id)
        {
            var empresa = await _context.Enterprises.FindAsync(id);
            return empresa;
        }

        public async Task<List<EnterpriseModel>> ListarEmpresas()
        {
            var lista = await _context.Enterprises.ToListAsync();
            return lista;
        }
    }
}
