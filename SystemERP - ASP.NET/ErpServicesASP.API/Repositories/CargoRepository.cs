using Azure;
using ErpServicesASP.API.Data;
using ErpServicesASP.API.Dto.Cargo;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace ErpServicesASP.API.Repositories
{
    public class CargoRepository : ICargoRepository
    {

        private readonly AppDbContext _context;
        public CargoRepository(AppDbContext context) { _context = context; }

        public async Task<ResponseModel<CargoModel?>> AtualizarCargo(CargoModel atualizacaoCargo)
        {
            ResponseModel<CargoModel?> response = new ResponseModel<CargoModel?>();
            try
            {
                var cargo = await BuscarCargoPorId(atualizacaoCargo.idCargo);
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

        public async Task<ResponseModel<CargoModel>> CriarCargo(CargoCreateDto novoCargo)
        {
            ResponseModel<CargoModel> response = new ResponseModel<CargoModel>();
            try
            {
                var cargoExiste = await _context.Cargos.FirstOrDefaultAsync(c => c.Name == novoCargo.Name);
                if (cargoExiste != null)
                {
                    response.Valor = cargoExiste;
                    response.Mensagem = "Cargo já existe";
                    response.Status = false;
                    return response;
                }
                var cargo = new CargoModel(){ Name = novoCargo.Name };
                await _context.Cargos.AddAsync(cargo);
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

        public async Task<ResponseModel<List<CargoModel>>> DeletarCargoPorId(int id)
        {
            ResponseModel<List<CargoModel>> response = new ResponseModel<List<CargoModel>>();
            try
            {
                var cargo = await BuscarCargoPorId(id);
                if(cargo == null)
                {
                    response.Mensagem = "Cargo não foi encontrado";
                    response.Status = false;
                    return response;
                }
                _context.Cargos.Remove(cargo);
                await _context.SaveChangesAsync();
                response.Valor = await _context.Cargos.ToListAsync();
                return response;
            }
            catch (Exception ex)
            {
                response.Mensagem = ex.Message;
                response.Status = false;
                return response;
            }
        }

        public async Task<ResponseModel<CargoModel?>> GetCargoPorId(int id)
        {
            ResponseModel<CargoModel?> response = new ResponseModel<CargoModel?>();
            try
            {
                var cargo = await BuscarCargoPorId(id);
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

        public async Task<ResponseModel<List<CargoModel>>> ListarCargos()
        {
            ResponseModel<List<CargoModel>> response = new ResponseModel<List<CargoModel>>();
            try
            {
                response.Valor = await _context.Cargos.ToListAsync();
                return response;
            }
            catch (Exception ex)
            {
                response.Mensagem = ex.Message;
                response.Status = false;
                return response;
            }
        }

        private async Task<CargoModel?> BuscarCargoPorId(int id)
        {
            return await _context.Cargos.FindAsync(id);
        }
    }
}
