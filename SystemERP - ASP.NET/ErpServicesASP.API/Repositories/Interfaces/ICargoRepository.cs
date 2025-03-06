using ErpServicesASP.API.Dto.Cargo;
using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Repositories.Interfaces
{
    public interface ICargoRepository
    {
        Task<ResponseModel<PositionModel>> CreatePosition(CargoCreateDto novoCargo);
        Task<ResponseModel<List<PositionModel>>> ListPosition();
        Task<ResponseModel<PositionModel>> GetResponsePositionById(int id);
        Task<ResponseModel<PositionModel?>> UpdatePosition(PositionModel cargo);
        Task<ResponseModel<List<PositionModel>>> DeletePositionById(int id);
    }
}
