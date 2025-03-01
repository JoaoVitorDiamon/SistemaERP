using ErpServicesASP.API.Controllers;
using ErpServicesASP.API.Dto;
using ErpServicesASP.API.Model;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services;
using ErpServicesASP.API.Services.Interfaces;
using Microsoft.AspNetCore.Mvc;
using Moq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ErpServicesASP.API.Test
{
    public class UsuarioServiceTest
    {
        private readonly IUsuarioService _service;
        private readonly Mock<IUsuarioRepository> _usuarioRepositoryMock;
        private readonly Mock<IValidacaoEmailService> _validacaoEmailServiceMock;
        public UsuarioServiceTest()
        {
            _usuarioRepositoryMock = new Mock<IUsuarioRepository>();
            _validacaoEmailServiceMock = new Mock<IValidacaoEmailService>();
            _service = new UsuarioService(_usuarioRepositoryMock.Object, _validacaoEmailServiceMock.Object);
        }

        [Fact(DisplayName = "Criar usuario: Sucesso")]
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
            var validacaoResponse = new ResponseModel<ValidacaoEmailModel>();
            var resultadoEsperado = new ResponseModel<UserModel>() { Valor = novoUsuarioModel, Status = true};
            _usuarioRepositoryMock.Setup(repository => repository.CriarUsuario(novoUsuario)).ReturnsAsync(novoUsuarioModel);

            var resultado = await _service.CriarUsuario(novoUsuario);
            Assert.NotNull(resultado);
            Assert.True(resultado.Status);
            Assert.Equal(novoUsuarioModel.Email, resultado.Valor.Email);
            Assert.Equal(novoUsuarioModel.CPF, resultado.Valor.CPF);
            Assert.Equal(novoUsuarioModel.Name, resultado.Valor.Name);
        }

        [Fact(DisplayName = "Criar usuario: Não consegue criar")]
        public async void CriarUsuario_RetornarNulo()
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
            var validacaoResponse = new ResponseModel<ValidacaoEmailModel>();
            var resultadoEsperado = new ResponseModel<UserModel>() { Mensagem = "Erro ao criar usuário", Status = false };
            _usuarioRepositoryMock.Setup(repository => repository.CriarUsuario(novoUsuario)).ReturnsAsync((UserModel)null);

            var resultado = await _service.CriarUsuario(novoUsuario);
            Assert.NotNull(resultado);
            Assert.Equal(resultadoEsperado.Status, resultado.Status);
            Assert.Equal(resultadoEsperado.Mensagem, resultado.Mensagem);
        }

        [Fact(DisplayName = "Criar usuario: Email ou CPF já cadastrado")]
        public async void CriarUsuario_EmailOuCPFJaExiste()
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
            var validacaoResponse = new ResponseModel<ValidacaoEmailModel>();
            var resultadoEsperado = new ResponseModel<UserModel>() { Mensagem = "Email ou CPF já cadastrados", Status = false };
            _usuarioRepositoryMock.Setup(repository => repository.UsuarioJaExiste(novoUsuario)).ReturnsAsync(true);

            var resultado = await _service.CriarUsuario(novoUsuario);
            Assert.NotNull(resultado);
            Assert.Equal(resultadoEsperado.Status, resultado.Status);
            Assert.Equal(resultadoEsperado.Mensagem, resultado.Mensagem);
        }
    }
}
