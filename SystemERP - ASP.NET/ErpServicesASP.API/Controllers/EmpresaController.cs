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
        public async Task<ActionResult<ResponseModel<List<EnterpriseModel>>>> ListEnterprises()
        {
            var response = await _service.ListEnterprises();
            if (!response.Status) return BadRequest(response);
            return Ok(response);
        }
        /// <summary>
        /// Cria uma empresa.
        /// </summary>
        [HttpPost]
        public async Task<ActionResult<ResponseModel<EnterpriseModel>>> CreateEnterprise(EnterpriseCreateDto novaEmpresa)
        {
            var response = await _service.CreateEnterprise(novaEmpresa);
            if (!response.Status) return BadRequest(response);
            return Ok(response);
        }
        /// <summary>
        /// Obtém uma empresa com base no id.
        /// </summary>
        [HttpGet("{id}")]
        public async Task<ActionResult<ResponseModel<EnterpriseModel>>> GetEnterpriseById(int id)
        {
            var response = await _service.GetEnterpriseById(id);
            if (response.Mensagem == "Empresa não encontrada") return NotFound(response);
            else if (!response.Status) return BadRequest(response);
            return Ok(response);
        }
        [HttpGet("cep/{cep}")]
        public async Task<ActionResult> GetCep(string cep)
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
        public async Task<ActionResult<ResponseModel<string>>> CheckIfCnpjUsed(string cnpj)
        {
            var response = await _service.CheckIfCnpjUsed(cnpj);
            if (!response.Status) return BadRequest(response);
            return Ok(response);
        }
        [HttpGet("Email/{email}")]
        public async Task<ActionResult<ResponseModel<string>>> CheckIfEmailUsed(string email)
        {
            var response = await _service.CheckIfEmailUsed(email);
            if (!response.Status) return BadRequest(response);
            return Ok(response);
        }
    }
}
