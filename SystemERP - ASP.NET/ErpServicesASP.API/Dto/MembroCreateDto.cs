using ErpServicesASP.API.Model;

namespace ErpServicesASP.API.Dto
{
    public class MembroCreateDto
    {
        public int Empresa_idEmpresa { get; set; }
        public int Usuario_idUsuario { get; set; }
        public int Cargo_idCargo { get; set; }
        public string NaturezaMembro { get; set; }
        public string Genero { get; set; }
        public string Senha { get; set; }
        public string Telefone { get; set; }
        public string CEP { get; set; }
        public DateTime DataNascimento { get; set; }
        public string AssociacaoPublica { get; set; }
    }
}
