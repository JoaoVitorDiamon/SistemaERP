//using ErpServicesASP.API.Data;
//using ErpServicesASP.API.Dto;
//using ErpServicesASP.API.Model;
//using ErpServicesASP.API.Repositories.Interfaces;
//using ErpServicesASP.API.Services.Interfaces;

//namespace ErpServicesASP.API.Services
//{
//    public class ValidacaoEmailService : IValidacaoEmailService
//    {
//        private readonly IValidacaoEmailRepository _repository;
//        private readonly MailService _mailService;
//        public ValidacaoEmailService(IValidacaoEmailRepository repository, MailService mailService)
//        {
//            _repository = repository;
//            _mailService = mailService;
//        }

//        public async Task<ResponseModel<ValidacaoEmailModel>> EnviarEmailValidacao(UserModel usuario)
//        {
//            ResponseModel<ValidacaoEmailModel> response = new ResponseModel<ValidacaoEmailModel>();
//            try
//            {
//                var validacaoEnviada = await _repository.ValidacaoJaEnviada(usuario);
//                if (validacaoEnviada)
//                {
//                    response.setErro("Email já enviado");
//                    return response;
//                }
//                var validacao = await _repository.CriarValidacao(usuario);
//                _mailService.EnviarEmail(usuario.Email, "SISTEMA ERP - VERIFICAÇÃO", "Código: " + validacao.Codigo);
//                response.Valor = validacao;
//                return response;
//            }
//            catch (Exception ex)
//            {
//                response.setErro("Erro: " + ex.Message);
//                return response;
//            }
//        }

//        public async Task<ResponseModel<ValidacaoEmailModel>> ValidarEmail(ValidacaoEmailDto dadosRequisicao)
//        {
//            ResponseModel<ValidacaoEmailModel> response = new ResponseModel<ValidacaoEmailModel>();
//            try
//            {
//                var validacao = await _repository.BuscarValidacaoPorEmail(dadosRequisicao.email);
//                if (validacao == null)
//                {
//                    response.setErro("Email não encontrado");
//                    return response;
//                }
//                if (validacao.Codigo != dadosRequisicao.codigo)
//                {
//                    response.setErro("Código inválido");
//                    return response;
//                }
//                var emailValidado = await _repository.ValidarEmail(validacao);
//                response.Valor = emailValidado;
//                return response;
//            }
//            catch (Exception ex)
//            {
//                response.setErro("Erro: " + ex.Message);
//                return response;
//            }
//        }
//    }
//}
