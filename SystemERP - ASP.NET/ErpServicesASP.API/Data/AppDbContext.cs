using ErpServicesASP.API.Dto;
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
        public DbSet<UserModel> Users { get; set; }
        public DbSet<CargoModel> Cargos { get; set; }
        public DbSet<EnterpriseTypeModel> EnterpriseTypes { get; set; }
        public DbSet<EnterpriseModel> Enterprises { get; set; }
        public DbSet<MemberModel> Members { get; set; }
        //public DbSet<ValidacaoEmailModel> ValidacoesDeEmails { get; set; }
        public DbSet<SectorModel> Sectors { get; set; }
        public DbSet<AddressModel> Addresses { get; set; }
        public DbSet<ThirdPartiesModel> terceiros { get; set; }
        public DbSet<StorageModel> armazem { get; set; }
        public DbSet<TelephoneModel> Telephones { get; set; }
    }
}
