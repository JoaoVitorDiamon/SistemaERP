using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace ErpServicesASP.API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ValidacaoEmailController : ControllerBase
    {
        private readonly IValidacaoEmailRepository _repository;
        public ValidacaoEmailController(IValidacaoEmailRepository repository)
        {
            _repository = repository;
        }
        [HttpPost]
        public async Task<ActionResult<ResponseModel<string>>> ValidarEmail([FromBody] string email, string codigo)
        {
            var teste = await _repository.ValidarEmail(email, codigo);
            return Ok(teste);
        } 
    }
}
