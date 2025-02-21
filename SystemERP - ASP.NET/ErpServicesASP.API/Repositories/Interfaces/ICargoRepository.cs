using ErpServicesASP.API.Dto.Cargo;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface ICargoRepository
    {
        Task<ResponseModel<CargoModel>> CriarCargo(CargoCreateDto novoCargo);
        Task<ResponseModel<List<CargoModel>>> ListarCargos();
        Task<ResponseModel<CargoModel>> GetCargoPorId(int id);
        Task<ResponseModel<CargoModel?>> AtualizarCargo(CargoModel cargo);
        Task<ResponseModel<List<CargoModel>>> DeletarCargoPorId(int id);
    }
}
