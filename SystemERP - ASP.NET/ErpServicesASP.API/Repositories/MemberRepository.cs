using ErpServicesASP.API.Data;
using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;
using System;

namespace ErpServicesASP.API.Repositories
{
    public class MemberRepository : IMembroRepository
    {
        private readonly AppDbContext _context;
        public MemberRepository(AppDbContext context) 
        {
            _context = context;
        }

        public async Task<MemberModel> CriarMembro(MemberCreateDto novoMembro, UserModel usuario, PositionModel cargo, EnterpriseModel empresa)
        {
            MemberModel membro = new MemberModel();
            membro.Enterprise = empresa;
            membro.User = usuario;
            membro.Position = cargo;
            membro.NatureMember = novoMembro.NatureMember;
            membro.Gender = novoMembro.Gender;
            membro.DateOfBirth = novoMembro.DateOfBirth;
            membro.PublicAssociation = novoMembro.PublicAssociation;
            membro.ZipCode = novoMembro.ZipCode;
            membro.Telephone = novoMembro.Telephone;
            await _context.Members.AddAsync(membro);
            await _context.SaveChangesAsync();
            return membro;
        }

        public async Task<MemberGetIdDto> GetMembroPorId(int membroId)
        {
            var membro = await _context.Members
                .Include(mem => mem.User)
                .Include(mem => mem.Enterprise)
                .Include(mem => mem.Position)
                .FirstOrDefaultAsync(mem => mem.IdMembers == membroId);

            var membroGet = new MemberGetIdDto() { 
                Cargo_idCargo = membro.Position.IdPosition,
                Empresa_idEmpresa = membro.Enterprise.IdEnterprise,
                Usuario_idUsuario = membro.User.IdUser,
                idMembro = membro.IdMembers,
                NaturezaMembro = membro.NatureMember
            };
            return membroGet;
        }

        public async Task<List<MemberGetIdDto>> ListarMembros()
        {
            var lista = await _context.Members
                .Include(mem => mem.Position)
                .Include(mem => mem.Enterprise)
                .Include(mem => mem.User)
                .ToListAsync();
            var listaMembroGet = new List<MemberGetIdDto>();
            foreach (MemberModel membro in lista)
            {
                var membroGet = new MemberGetIdDto()
                {
                    Cargo_idCargo = membro.Position.IdPosition,
                    Empresa_idEmpresa = membro.Enterprise.IdEnterprise,
                    Usuario_idUsuario = membro.User.IdUser,
                    idMembro = membro.IdMembers,
                    NaturezaMembro = membro.NatureMember
                };
                listaMembroGet.Add(membroGet);
            }
            return listaMembroGet;
        }

        public async Task<bool> MembroJaExiste(MemberCreateDto novoMembro)
        {
            var idExiste = await _context.Members.FirstOrDefaultAsync(membro => membro.User.IdUser == novoMembro.Usuario_idUsuario);
            if (idExiste == null) return false;
            return true;
        }
    }
}
