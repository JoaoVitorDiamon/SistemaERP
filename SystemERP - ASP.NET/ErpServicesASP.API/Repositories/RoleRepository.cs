using Azure;
using ErpServicesASP.API.Data;
using ErpServicesASP.API.Dto.Cargo;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace ErpServicesASP.API.Repositories
{
    public class RoleRepository : ICargoRepository
    {

        private readonly AppDbContext _context;
        public RoleRepository(AppDbContext context) { _context = context; }

        public async Task<ResponseModel<PositionModel?>> UpdatePosition(PositionModel atualizacaoCargo)
        {
            ResponseModel<PositionModel?> response = new ResponseModel<PositionModel?>();
            try
            {
                var cargo = await GetPositionById(atualizacaoCargo.IdPosition);
                if (cargo == null) 
                {
                    response.Mensagem = "Não foi possivel localizar esse cargo";
                    response.Status = false;
                    return response;
                }

                cargo.Name = atualizacaoCargo.Name;
                await _context.SaveChangesAsync();
                response.Valor = atualizacaoCargo;
                return response;
            }
            catch (Exception ex)
            {
                response.Mensagem = ex.Message;
                response.Status = false;
                return response;
            }
        }

        public async Task<ResponseModel<PositionModel>> CreatePosition(CargoCreateDto novoCargo)
        {
            ResponseModel<PositionModel> response = new ResponseModel<PositionModel>();
            try
            {
                var cargoExiste = await _context.Position.FirstOrDefaultAsync(c => c.Name == novoCargo.Name);
                if (cargoExiste != null)
                {
                    response.Valor = cargoExiste;
                    response.Mensagem = "Cargo já existe";
                    response.Status = false;
                    return response;
                }
                var cargo = new PositionModel(){ Name = novoCargo.Name };
                await _context.Position.AddAsync(cargo);
                await _context.SaveChangesAsync();
                response.Valor = cargo;
                return response;
            }
            catch (Exception ex)
            {
                response.Mensagem = ex.Message;
                response.Status = false;
                return response;
            }
        }

        public async Task<ResponseModel<List<PositionModel>>> DeletePositionById(int id)
        {
            ResponseModel<List<PositionModel>> response = new ResponseModel<List<PositionModel>>();
            try
            {
                var cargo = await GetPositionById(id);
                if(cargo == null)
                {
                    response.Mensagem = "Cargo não foi encontrado";
                    response.Status = false;
                    return response;
                }
                _context.Position.Remove(cargo);
                await _context.SaveChangesAsync();
                response.Valor = await _context.Position.ToListAsync();
                return response;
            }
            catch (Exception ex)
            {
                response.Mensagem = ex.Message;
                response.Status = false;
                return response;
            }
        }

        public async Task<ResponseModel<PositionModel>> GetResponsePositionById(int id)
        {
            ResponseModel<PositionModel> response = new ResponseModel<PositionModel>();
            try
            {
                var cargo = await GetPositionById(id);
                if (cargo == null)
                {
                    response.Mensagem = "Não foi possivel encontrar esse cargo";
                    response.Status = false;
                    return response;
                }
                response.Valor = cargo;
                return response;
            }
            catch(Exception ex)
            {
                response.Mensagem = ex.Message;
                response.Status = false;
                return response;
            }
        }

        public async Task<ResponseModel<List<PositionModel>>> ListPosition()
        {
            ResponseModel<List<PositionModel>> response = new ResponseModel<List<PositionModel>>();
            try
            {
                response.Valor = await _context.Position.ToListAsync();
                return response;
            }
            catch (Exception ex)
            {
                response.Mensagem = ex.Message;
                response.Status = false;
                return response;
            }
        }

        private async Task<PositionModel?> GetPositionById(int id)
        {
            return await _context.Position.FindAsync(id);
        }
    }
}
