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
        public Task<EnterpriseModel> UpdateEnterprise(EnterpriseModel empresaAtualizada)
        {
            throw new NotImplementedException();
        }

        public async Task<bool> CheckIfCnpjUsed(string cnpj)
        {
            var cnpjJaExiste = await _context.Enterprise.FirstOrDefaultAsync(empresa => empresa.CNPJ == cnpj);
            if (cnpjJaExiste != null) return true;
            return false;
        }
        public async Task<bool> CheckIfEmailUsed(string email)
        {
            var emailUsado = await _context.Enterprise.FirstOrDefaultAsync(empresa => empresa.Email == email);
            if (emailUsado != null) return true;
            return false;
        }

        public async Task<EnterpriseModel> CreateEnterprise(EnterpriseCreateDto novaEmpresa)
        {
            var owner = await _context.Users.FindAsync(novaEmpresa.IdOwner);
            var tipoEmpresa = await _context.EnterpriseType.FindAsync(novaEmpresa.IdEnterpriseType);
            var setor = await _context.Sector.FindAsync(novaEmpresa.IdSector);
            var address = await _context.Adress.FindAsync(novaEmpresa.IdAddress);
            EnterpriseModel empresa = new EnterpriseModel()
            {
                Name = novaEmpresa.Name,
                NameFantasy = novaEmpresa.FantasyName,
                Owner = owner,
                CNPJ = novaEmpresa.CNPJ,
                Email = novaEmpresa.Email,
                CompanyType = tipoEmpresa,
                Sector = setor,
                Address = address,
                CreationDate = novaEmpresa.CreationDate
            };
            await _context.Enterprise.AddAsync(empresa);
            await _context.SaveChangesAsync();
            return empresa;
        }

        public async Task<List<EnterpriseModel>> DeleteEnterpriseByID(EnterpriseModel empresa)
        {
            _context.Enterprise.Remove(empresa);
            await _context.SaveChangesAsync();
            return await ListEnterprises();
        }

        public async Task<bool> CheckExistenceEnterprise(EnterpriseCreateDto novaEmpresa)
        {
            var cnpjJaExiste = await _context.Enterprise.FirstOrDefaultAsync(empresa => empresa.CNPJ == novaEmpresa.CNPJ);
            if (cnpjJaExiste != null) return true;
            var email = await _context.Enterprise.FirstOrDefaultAsync(empresa => empresa.Email == novaEmpresa.Email);
            if (email != null) return true;
            return false;

        }

        public async Task<EnterpriseModel> GetEnterpriseById(int id)
        {
            var empresa = await _context.Enterprise.FindAsync(id);
            return empresa;
        }

        public async Task<List<EnterpriseModel>> ListEnterprises()
        {
            var lista = await _context.Enterprise.ToListAsync();
            return lista;
        }
    }
}
