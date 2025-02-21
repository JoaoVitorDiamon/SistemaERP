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
        public Task<EmpresaModel> AtualizarEmpresa(EmpresaModel empresaAtualizada)
        {
            throw new NotImplementedException();
        }

        public async Task<EmpresaModel> CriarEmpresa(EmpresaCreateDto novaEmpresa)
        {
            var dono = await _context.Usuarios.FindAsync(novaEmpresa.idDono);
            var tipoEmpresa = await _context.TipoDeEmpresa.FindAsync(novaEmpresa.idTipoDeEmpresa);
            EmpresaModel empresa = new EmpresaModel()
            {
                Name = novaEmpresa.Name,
                NomeFantasia = novaEmpresa.NomeFantasia,
                Dono = dono,
                CNPJ = novaEmpresa.CNPJ,
                Email = novaEmpresa.Email,
                Telefone = novaEmpresa.Telefone,
                Endereco = novaEmpresa.Endereco,
                TipoDeEmpresa = tipoEmpresa,
                DataCriacao = novaEmpresa.DataCriacao
            };
            await _context.Empresas.AddAsync(empresa);
            await _context.SaveChangesAsync();
            return empresa;
        }

        public async Task<List<EmpresaModel>> DeletarEmpresaPeloId(EmpresaModel empresa)
        {
            _context.Empresas.Remove(empresa);
            await _context.SaveChangesAsync();
            return await ListarEmpresas();
        }

        public async Task<bool> empresaJaExiste(EmpresaCreateDto novaEmpresa)
        {
            var nomeJaExiste = await _context.Empresas.FirstOrDefaultAsync(empresa => empresa.Name == novaEmpresa.Name);
            if (nomeJaExiste != null) return true;
            var cnpjJaExiste = await _context.Empresas.FirstOrDefaultAsync(empresa => empresa.CNPJ == novaEmpresa.CNPJ);
            if (cnpjJaExiste != null) return true;
            var email = await _context.Empresas.FirstOrDefaultAsync(empresa => empresa.Email == novaEmpresa.Email);
            if (email != null) return true;
            return false;

        }

        public async Task<EmpresaModel> GetEmpresaPeloId(int id)
        {
            var empresa = await _context.Empresas.FindAsync(id);
            return empresa;
        }

        public async Task<List<EmpresaModel>> ListarEmpresas()
        {
            var lista = await _context.Empresas.ToListAsync();
            return lista;
        }
    }
}
