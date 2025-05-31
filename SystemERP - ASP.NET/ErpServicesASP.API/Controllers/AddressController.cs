using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Services.Interfaces;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;

namespace ErpServicesASP.API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AddressController : ControllerBase
    {
        private readonly IAddressService _service;
        public AddressController(IAddressService service) { _service = service; }
        [HttpGet("{id}")]
        public async Task<ActionResult<ResponseModel<AddressModel>>> GetAdressById(int id)
        {
            var response = await _service.GetAdressById(id);
            if(response.Mensagem.IsNullOrEmpty()) return Ok(response);
            else if (response.Mensagem.Contains("Erro")) return BadRequest(response);
            else if (!response.Status) return NotFound(response);
            return Ok(response);
        }

        [HttpPost]
        public async Task<ActionResult<ResponseModel<AddressModel>>> CreateAddress(AddressCreateDto newAdress)
        {
            var response = await _service.CreateAddress(newAdress);
            if (!response.Status) return BadRequest(response);
            return Ok(response);
        }
    }
}
