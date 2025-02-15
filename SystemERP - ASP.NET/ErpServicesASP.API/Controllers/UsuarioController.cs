using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace ErpServicesASP.API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UsuarioController : ControllerBase
    {
        private readonly UsuarioService _service;
        public UsuarioController(UsuarioService service)
        {
            _service = service;
        }

        [HttpGet]
        public async Task<ActionResult<ResponseModel<List<UsuarioModel>>>> ListarUsuarios()
        {
            var lista = await _service.ListarUsuarios();
            return Ok(lista);
        }
        [HttpPost]
        public async Task<ActionResult<ResponseModel<UsuarioModel>>> CriarUsuario(UsuarioCreateDto novoUsuario)
        {
            if (novoUsuario == null)
                return BadRequest("Dados inválidos");

            var response = await _service.CriarUsuario(novoUsuario);
            if (response.Mensagem == "Email ou CPF já cadastrados")
                return Conflict(response);
            if (!response.Status)
                return BadRequest(response);
            return Ok(response);
        }


    }
}
