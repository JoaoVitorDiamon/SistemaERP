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
        public DbSet<PositionModel> Position { get; set; }
        public DbSet<EnterpriseTypeModel> EnterpriseType { get; set; }
        public DbSet<EnterpriseModel> Enterprise { get; set; }
        public DbSet<MemberModel> Members { get; set; }
        //public DbSet<ValidacaoEmailModel> ValidacoesDeEmails { get; set; }
        public DbSet<SectorModel> Sector { get; set; }
        public DbSet<AddressModel> Adress { get; set; }
        public DbSet<ThirdPartiesModel> terceiro { get; set; }
        public DbSet<StorageModel> armazem { get; set; }
        public DbSet<TelephoneModel> Telephone { get; set; }
    }

}
