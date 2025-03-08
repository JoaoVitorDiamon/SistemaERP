using ErpServicesASP.API.Dto.Cargo;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace ErpServicesASP.API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CargoController : ControllerBase
    {
        private readonly ICargoRepository _repository;
        public CargoController(ICargoRepository repository) { _repository = repository; }

        /// <summary>
        /// Obtém uma lista com todos os cargos.
        /// </summary>
        [HttpGet]
        public async Task<ActionResult<ResponseModel<List<PositionModel>>>> ListarCargos()
        {
            var response = await _repository.ListPosition();
            if (!response.Status)
            {
                return BadRequest(response);
            }
            return Ok(response);
        }

        /// <summary>
        /// Obtém um cargo pelo ID.
        /// </summary>
        [HttpGet("{idcargo}")]
        public async Task<ActionResult<ResponseModel<PositionModel>>> GetCargoPorId(int idcargo)
        {
            var response = await _repository.GetResponsePositionById(idcargo);
            if (!response.Status)
            {
                return BadRequest(response);
            }
            return Ok(response);
        }

        /// <summary>
        /// Cria um cargo.
        /// </summary>
        [HttpPost]
        public async Task<ActionResult<ResponseModel<PositionModel>>> CriarCargo(CargoCreateDto novoCargo)
        {
            var response = await _repository.CreatePosition(novoCargo);
            if (!response.Status)
            {
                return BadRequest(response);
            }
            return Ok(response);
        }

        /// <summary>
        /// Altera o nome do cargo pelo ID.
        /// </summary>
        [HttpPut]
        public async Task<ActionResult<ResponseModel<PositionModel>>> CriarCargo(PositionModel cargo)
        {
            var response = await _repository.UpdatePosition(cargo);
            if (!response.Status)
            {
                return BadRequest(response);
            }
            return Ok(response);
        }

        /// <summary>
        /// Deleta um cargo pelo ID.
        /// </summary>
        [HttpDelete("delete/{idcargo}")]
        public async Task<ActionResult<ResponseModel<List<PositionModel>>>> DeletarCargoPorId(int idcargo)
        {
            var response = await _repository.DeletePositionById(idcargo);
            if (!response.Status)
            {
                return BadRequest(response);
            }
            return Ok(response);
        }
    }
}
