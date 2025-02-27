using ErpServicesASP.API.Model;
using Microsoft.EntityFrameworkCore;

namespace ErpServicesASP.API.Data
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options) : base(options)
        {
            AppContext.SetSwitch("Npgsql.EnableLegacyTimestampBehavior", true);
        }
        public DbSet<UsuarioModel> Usuarios { get; set; }
        public DbSet<CargoModel> Cargos { get; set; }
        public DbSet<TipoDeEmpresaModel> TipoDeEmpresa { get; set; }
        public DbSet<EmpresaModel> Empresas { get; set; }
        public DbSet<MembroModel> Membros { get; set; }
        public DbSet<ValidacaoEmailModel> ValidacoesDeEmails { get; set; }
        public DbSet<SetorModel> Setores { get; set; }
    }
}
