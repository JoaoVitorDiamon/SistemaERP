using ErpServicesASP.API.Controllers;
using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services;
using ErpServicesASP.API.Services.Interfaces;
using Microsoft.AspNetCore.Mvc;
using Moq;
using System.Runtime.ConstrainedExecution;

namespace ErpServicesASP.API.Test
{
    public class UsuarioControllerTest
    {
        private readonly UsuarioController _controller;
        private readonly Mock<IUsuarioService> _usuarioServiceyMock;
        private readonly Mock<IValidacaoEmailService> _validacaoEmailServiceMock;
        public UsuarioControllerTest() 
        {
            _usuarioServiceyMock = new Mock<IUsuarioService>();
            _validacaoEmailServiceMock = new Mock<IValidacaoEmailService>();
            _controller = new UsuarioController(_usuarioServiceyMock.Object);
        }

        [Fact(DisplayName = "Resultado OK")]
        public async void CriarUsuario()
        {
            var novoUsuario = new UsuarioCreateDto()
                {
                    Name = "Khaléu",
                    CPF = "445",
                    Email = "hauleksm@gmail.com",
                    Telefone = "123",
                    Genero = "masculino",
                    Senha = "123",
                    CEP = "123",
                    Endereco = "teste",
                    DataNascimento = DateTime.Now,
                    AssociacaoPublica = "sim"
                };
            var novoUsuarioModel = new UsuarioModel
                (novoUsuario.Name,
                novoUsuario.CPF,
                novoUsuario.Telefone,
                novoUsuario.Email,
                novoUsuario.Genero,
                novoUsuario.Senha,
                novoUsuario.CEP,
                novoUsuario.Endereco,
                novoUsuario.DataNascimento,
                novoUsuario.AssociacaoPublica
                );
            var resultadoEsperado = new ResponseModel<UserModel>() { Valor = novoUsuarioModel, Status = true };
            _usuarioServiceyMock.Setup(service => service.CriarUsuario(novoUsuario)).ReturnsAsync(resultadoEsperado);

            var result = await _controller.CriarUsuario(novoUsuario);

            var okResult = Assert.IsType<OkObjectResult>(result.Result);
            var actualValue = Assert.IsType<ResponseModel<UserModel>>(okResult.Value);
            Assert.Equal(resultadoEsperado.Status, actualValue.Status);
            Assert.Equal(Newtonsoft.Json.JsonConvert.SerializeObject(resultadoEsperado.Valor),
                         Newtonsoft.Json.JsonConvert.SerializeObject(actualValue.Valor));
        }
    }
}