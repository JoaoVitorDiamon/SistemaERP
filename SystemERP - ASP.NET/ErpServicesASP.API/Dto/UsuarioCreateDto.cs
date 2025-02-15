namespace ErpServicesASP.API.Dto
{
    public class UsuarioCreateDto
    {
        public string Name { get; set; }
        public string CPF { get; set; }
        public string Telefone { get; set; }
        public string Email { get; set; }
        public string Genero { get; set; }
        public string Senha { get; set; }
        public string CEP { get; set; }
        public string Endereco { get; set; }
        public DateTime DataNascimento { get; set; }
        public string AssociacaoPublica { get; set; }

    }
}
