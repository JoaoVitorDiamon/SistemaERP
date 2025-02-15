using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services.Interfaces;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace ErpServicesASP.API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ValidacaoEmailController : ControllerBase
    {
        private readonly IValidacaoEmailService _service;
        public ValidacaoEmailController(IValidacaoEmailService service)
        {
            _service = service;
        }
        [HttpPost]
        public async Task<ActionResult<ResponseModel<string>>> ValidarEmail(ValidacaoEmailDto dadosRequisicao)
        {
            if(dadosRequisicao == null)
                return BadRequest("Dados inválidos");

            var response = await _service.ValidarEmail(dadosRequisicao);
            if(response.Mensagem == "Email não encontrado")
                return NotFound(response);
            if (!response.Status)
                return BadRequest(response);

            return Ok(response);
        } 
    }
}
