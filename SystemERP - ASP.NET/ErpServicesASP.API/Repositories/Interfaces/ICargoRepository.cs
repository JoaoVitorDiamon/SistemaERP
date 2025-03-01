using ErpServicesASP.API.Dto.Cargo;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface ICargoRepository
    {
        Task<ResponseModel<PositionModel>> CriarCargo(CargoCreateDto novoCargo);
        Task<ResponseModel<List<PositionModel>>> ListarCargos();
        Task<ResponseModel<PositionModel>> GetCargoPorId(int id);
        Task<ResponseModel<PositionModel?>> AtualizarCargo(PositionModel cargo);
        Task<ResponseModel<List<PositionModel>>> DeletarCargoPorId(int id);
    }
}
