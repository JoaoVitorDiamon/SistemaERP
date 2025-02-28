using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Services.Interfaces;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace ErpServicesASP.API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EmpresaController : ControllerBase
    {
        private readonly IEmpresaService _service;
        public EmpresaController(IEmpresaService service) { _service = service; }


        /// <summary>
        /// Obtém uma lista com todos as empresas.
        /// </summary>
        [HttpGet]
        public async Task<ActionResult<ResponseModel<List<EmpresaModel>>>> ListarEmpresas()
        {
            var response = await _service.ListarEmpresas();
            if (!response.Status) return BadRequest(response);
            return Ok(response);
        }
        /// <summary>
        /// Cria uma empresa.
        /// </summary>
        [HttpPost]
        public async Task<ActionResult<ResponseModel<EmpresaModel>>> CriarEmpresa(EnterpriseCreateDto novaEmpresa)
        {
            var response = await _service.CriarEmpresa(novaEmpresa);
            if (!response.Status) return BadRequest(response);
            return Ok(response);
        }
        /// <summary>
        /// Obtém uma empresa com base no id.
        /// </summary>
        [HttpGet("{id}")]
        public async Task<ActionResult<ResponseModel<EmpresaModel>>> GetEmpresaPeloId(int id)
        {
            var response = await _service.GetEmpresaPeloId(id);
            if (response.Mensagem == "Empresa não encontrada") return NotFound(response);
            else if (!response.Status) return BadRequest(response);
            return Ok(response);
        }
        [HttpGet("cep/{cep}")]
        public async Task<ActionResult> getCep(string cep)
        {
            if(cep.Contains("-")){
                var cepe = cep.Split("-");
                cep = cepe[0] + cepe[1];
            }
            using (HttpClient client = new HttpClient()) { 
                string url = $"https://viacep.com.br/ws/{cep}/json/";
                var response = await client.GetStringAsync(url);
                return Content(response, "application/json");
            }
        }
        [HttpGet("CNPJ/{cnpj}")]
        public async Task<ActionResult<ResponseModel<string>>> CnpjJaUsado(string cnpj)
        {
            var response = await _service.CnpjJaUsado(cnpj);
            if (!response.Status) return BadRequest(response);
            return Ok(response);
        }
        [HttpGet("Email/{email}")]
        public async Task<ActionResult<ResponseModel<string>>> EmailJaUsado(string email)
        {
            var response = await _service.EmailJaUsado(email);
            if (!response.Status) return BadRequest(response);
            return Ok(response);
        }
    }
}
