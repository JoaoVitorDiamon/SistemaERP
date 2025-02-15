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
        private readonly IUsuarioRepository _repository;
        private readonly UsuarioService _service;
        public UsuarioController(IUsuarioRepository repository, UsuarioService service)
        {
            _repository = repository;
            _service = service;
        }

        [HttpGet]
        public async Task<ActionResult<ResponseModel<List<UsuarioModel>>>> ListarUsuarios()
        {
            var lista = await _repository.ListarUsuarios();
            return Ok(lista);
        }
        [HttpPost]
        public async Task<ActionResult<ResponseModel<UsuarioModel>>> CriarUsuario(UsuarioCreateDto novoUsuario)
        {
            var response = await _service.CriarUsuario(novoUsuario);
            return Ok(response);
        }


    }
}
