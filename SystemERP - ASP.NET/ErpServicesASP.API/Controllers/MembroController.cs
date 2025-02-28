using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Services.Interfaces;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace ErpServicesASP.API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class MembroController : ControllerBase
    {
        private readonly IMembroService _service;
        public MembroController(IMembroService service) { _service  = service; }
        [HttpGet]
        public async Task<ActionResult<ResponseModel<List<MemberGetIdDto>>>> ListarMembros()
        {
            var lista = await _service.ListarMembros();
            return Ok(lista);
        }
        [HttpGet("{id}")]
        public async Task<ActionResult<ResponseModel<MemberGetIdDto>>> GetMembroPorId(int id)
        {
            var response = await _service.GetMembroPorId(id);
            if (response.Mensagem == "Membro não encontrado") return NotFound(response);
            else if (!response.Status) return BadRequest(response);
            return Ok(response);
        }
        [HttpPost]
        public async Task<ActionResult<ResponseModel<MembroModel>>> CriarMembro(MemberCreateDto novoMembro)
        {
            var response = await _service.CriarMembro(novoMembro);
            if (response.Mensagem != null) 
            {
                if(response.Mensagem.Contains("não")) return NotFound(response);
                return BadRequest(response);
            } 
            return Ok(response);
        }
    }
}
