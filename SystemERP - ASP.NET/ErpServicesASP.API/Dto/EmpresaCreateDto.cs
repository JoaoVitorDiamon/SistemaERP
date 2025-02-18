using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Dto
{
    public class EmpresaCreateDto
    {
        public string Name { get; set; }
        public string NomeFantasia { get; set; }
        public int idDono { get; set; }
        public string CNPJ { get; set; }
        public string Email { get; set; }
        public string Telefone { get; set; }
        public string Endereco { get; set; }
        public int idTipoDeEmpresa { get; set; }
        public DateTime DataCriacao { get; set; }
    }
}
