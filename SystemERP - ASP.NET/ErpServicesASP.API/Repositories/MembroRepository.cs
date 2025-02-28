using ErpServicesASP.API.Data;
using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;
using System;

namespace ErpServicesASP.API.Repositories
{
    public class MembroRepository : IMembroRepository
    {
        private readonly AppDbContext _context;
        public MembroRepository(AppDbContext context) 
        {
            _context = context;
        }

        public async Task<MembroModel> CriarMembro(MemberCreateDto novoMembro, UsuarioModel usuario, CargoModel cargo, EmpresaModel empresa)
        {
            MembroModel membro = new MembroModel();
            membro.Empresa = empresa;
            membro.Usuario = usuario;
            membro.Cargo = cargo;
            membro.NaturezaMembro = novoMembro.NaturezaMembro;
            membro.Genero = novoMembro.Genero;
            membro.Telefone = novoMembro.Telefone;
            membro.CEP = novoMembro.CEP;
            membro.DataNascimento = novoMembro.DataNascimento;
            membro.AssociacaoPublica = novoMembro.AssociacaoPublica;
            await _context.Membros.AddAsync(membro);
            await _context.SaveChangesAsync();
            return membro;
        }

        public async Task<MemberGetIdDto> GetMembroPorId(int membroId)
        {
            var membro = await _context.Membros
                .Include(mem => mem.Usuario)
                .Include(mem => mem.Empresa)
                .Include(mem => mem.Cargo)
                .FirstOrDefaultAsync(mem => mem.idMembro == membroId);

            var membroGet = new MemberGetIdDto() { 
                Cargo_idCargo = membro.Cargo.idCargo,
                Empresa_idEmpresa = membro.Empresa.idEmpresa,
                Usuario_idUsuario = membro.Usuario.Id,
                idMembro = membro.idMembro,
                NaturezaMembro = membro.NaturezaMembro
            };
            return membroGet;
        }

        public async Task<List<MemberGetIdDto>> ListarMembros()
        {
            var lista = await _context.Membros
                .Include(mem => mem.Cargo)
                .Include(mem => mem.Empresa)
                .Include(mem => mem.Usuario)
                .ToListAsync();
            var listaMembroGet = new List<MemberGetIdDto>();
            foreach (MembroModel membro in lista)
            {
                var membroGet = new MemberGetIdDto()
                {
                    Cargo_idCargo = membro.Cargo.idCargo,
                    Empresa_idEmpresa = membro.Empresa.idEmpresa,
                    Usuario_idUsuario = membro.Usuario.Id,
                    idMembro = membro.idMembro,
                    NaturezaMembro = membro.NaturezaMembro
                };
                listaMembroGet.Add(membroGet);
            }
            return listaMembroGet;
        }

        public async Task<bool> MembroJaExiste(MemberCreateDto novoMembro)
        {
            var idExiste = await _context.Membros.FirstOrDefaultAsync(membro => membro.Usuario.Id == novoMembro.Usuario_idUsuario);
            if (idExiste == null) return false;
            return true;
        }
    }
}
