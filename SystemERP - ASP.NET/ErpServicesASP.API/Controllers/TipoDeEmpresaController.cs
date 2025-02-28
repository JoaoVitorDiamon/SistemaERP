using Azure;
using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Services.Interfaces;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace ErpServicesASP.API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class TipoDeEmpresaController : ControllerBase
    {
        private readonly ITipoDeEmpresaService _service;
        public TipoDeEmpresaController(ITipoDeEmpresaService service) { _service = service; }
        [HttpGet]
        public async Task<ActionResult<ResponseModel<List<TipoDeEmpresaModel>>>> ListarTiposDeEmpresa()
        {
            var response = await _service.ListarTiposDeEmpresa();
            if (response.Status == false)
                return BadRequest(response);
            return Ok(response);
        }
        [HttpGet("{id}")]
        public async Task<ActionResult<ResponseModel<TipoDeEmpresaModel>>> GetTipoDeEmpresaPorId(int id)
        {
            var response = await _service.GetTipoDeEmpresaPorID(id);
            if (response.Mensagem == "Tipo de empresa não existe")
                return NotFound(response);
            else if (response.Status == false)
                return BadRequest(response);
            return Ok(response);
        }
        [HttpPost]
        public async Task<ActionResult<ResponseModel<TipoDeEmpresaModel>>> CriarTipoDeEmpresa(EnterpriseTypeCreateDto novoTipoDeEmpresa)
        {
            var response = await _service.CriarTipoDeEmpresa(novoTipoDeEmpresa);
            if (response.Status == false)
                return BadRequest(response);
            return Ok(response);
        }
        [HttpPut]
        public async Task<ActionResult<ResponseModel<TipoDeEmpresaModel>>> AtualizarTipoDeEmpresa(TipoDeEmpresaModel tipoDeEmpresa)
        {
            var response = await _service.AtualizarTipoDeEmpresa(tipoDeEmpresa);
            if (response.Mensagem == "Tipo de empresa não existe")
                return NotFound(response);
            else if (response.Status == false)
                return BadRequest(response);
            return Ok(response);
        }
        [HttpDelete]
        public async Task<ActionResult<ResponseModel<TipoDeEmpresaModel>>> DeletarTipoDeEmpresa(int id)
        {
            var response = await _service.DeletarTipoDeEmpresa(id);
            if (response.Mensagem == "Tipo de empresa não existe")
                return NotFound(response);
            else if (response.Status == false)
                return BadRequest(response);
            return Ok(response);
        }
    }
}
