using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services;
using ErpServicesASP.API.Services.Interfaces;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace ErpServicesASP.API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UsuarioController : ControllerBase
    {
        private readonly IUsuarioService _service;
        public UsuarioController(IUsuarioService service)
        {
            _service = service;
        }

        /// <summary>
        /// Obtém uma lista com todos os usuários.
        /// </summary>
        [HttpGet]
        public async Task<ActionResult<ResponseModel<List<UserModel>>>> ListarUsuarios()
        {
            var lista = await _service.ListarUsuarios();
            return Ok(lista);
        }

        /// <summary>
        /// Adiciona um usuário no banco de dados.
        /// </summary>
        [HttpPost]
        public async Task<ActionResult<ResponseModel<UserModel>>> CriarUsuario(UsuarioCreateDto novoUsuario)
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

        /// <summary>
        /// Obtém um usuário pelo ID.
        /// </summary>
        [HttpGet("{id}")]
        public async Task<ActionResult<ResponseModel<UserModel>>> GetUsuarioPorId(int id)
        {
            var response = await _service.GetUsuarioPorId(id);
            if (response.Mensagem == "Usuário não encontrado")
                return NotFound(response);
            if (!response.Status)
                return BadRequest(response);
            return Ok(response);
        }


        /// <summary>
        /// Deleta um usuário pelo ID.
        /// </summary>
        [HttpDelete("{id}")]
        public async Task<ActionResult<ResponseModel<List<UserModel>>>> DeletarUsuarioPorId(int id)
        {
            var response = await _service.DeletarUsuarioPorId(id);
            if (response.Mensagem == "Usuário não encontrado")
                return NotFound(response);
            if (!response.Status)
                return BadRequest(response);
            return Ok(response);
        }

        [HttpGet("CPF/{cpf}")]
        public async Task<ActionResult<ResponseModel<string>>> VerificarExistenciaCPF(string cpf)
        {
            var response = await _service.VerificarExistenciaCPF(cpf);
            if(!response.Status) return BadRequest(response);
            return Ok(response);
        }

        [HttpGet("Email/{email}")]
        public async Task<ActionResult<ResponseModel<string>>> VerificarExistenciaEmail(string email)
        {
            var response = await _service.VerificarExistenciaEmail(email);
            if (!response.Status) return BadRequest(response);
            return Ok(response);
        }
    }
}
