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
    public class SetorController : ControllerBase
    {
        private readonly ISetorEmpresaService _service;
        public SetorController(ISetorEmpresaService service) { _service = service; }
        [HttpGet]
        public async Task<ActionResult<ResponseModel<List<SetorModel>>>> ListarTiposDeEmpresa()
        {
            var response = await _service.ListarSetoresEmpresa();
            if (response.Status == false)
                return BadRequest(response);
            return Ok(response);
        }
        [HttpGet("{id}")]
        public async Task<ActionResult<ResponseModel<SetorModel>>> GetTipoDeEmpresaPorId(int id)
        {
            var response = await _service.GetSetorEmpresaPorID(id);
            if (response.Mensagem == "Tipo de empresa não existe")
                return NotFound(response);
            else if (response.Status == false)
                return BadRequest(response);
            return Ok(response);
        }
        [HttpPost]
        public async Task<ActionResult<ResponseModel<SetorModel>>> CriarTipoDeEmpresa(SetorCreateDto novoSetor)
        {
            var response = await _service.CriarSetorEmpresa(novoSetor);
            if (response.Status == false)
                return BadRequest(response);
            return Ok(response);
        }
        [HttpPut]
        public async Task<ActionResult<ResponseModel<SetorModel>>> AtualizarTipoDeEmpresa(SetorModel setor)
        {
            var response = await _service.AtualizarSetorEmpresa(setor);
            if (response.Mensagem == "Tipo de empresa não existe")
                return NotFound(response);
            else if (response.Status == false)
                return BadRequest(response);
            return Ok(response);
        }
        [HttpDelete]
        public async Task<ActionResult<ResponseModel<SetorModel>>> DeletarTipoDeEmpresa(int id)
        {
            var response = await _service.DeletarSetorEmpresa(id);
            if (response.Mensagem == "Tipo de empresa não existe")
                return NotFound(response);
            else if (response.Status == false)
                return BadRequest(response);
            return Ok(response);
        }
    }
}
