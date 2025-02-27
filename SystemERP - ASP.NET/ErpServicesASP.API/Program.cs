using ErpServicesASP.API.Data;
using ErpServicesASP.API.Repositories;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services;
using ErpServicesASP.API.Services.Interfaces;
using Microsoft.EntityFrameworkCore;
using System.Reflection;

var builder = WebApplication.CreateBuilder(args);
var MyAllowSpecificOrigins = "_MyAllowSubdomainPolicy";
// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddScoped<ICargoRepository, CargoRepository>();
builder.Services.AddScoped<IUsuarioRepository, UsuarioRepository>();
builder.Services.AddScoped<IValidacaoEmailRepository, ValidacaoEmailRepository>();
builder.Services.AddScoped<IUsuarioService, UsuarioService>();
builder.Services.AddScoped<IValidacaoEmailService, ValidacaoEmailService>();
builder.Services.AddScoped<ITipoDeEmpresaRepository, TipoDeEmpresaRepository>();
builder.Services.AddScoped<ITipoDeEmpresaService, TipoDeEmpresaService>();
builder.Services.AddScoped<ISetorEmpresaRepository, SetorEmpresaRepository>();
builder.Services.AddScoped<ISetorEmpresaService, SetorDeEmpresaService>();
builder.Services.AddScoped<IEmpresaRepository, EmpresaRepository>();
builder.Services.AddScoped<IEmpresaService, EmpresaService>();
builder.Services.AddScoped<IMembroRepository, MembroRepository>();
builder.Services.AddScoped<IMembroService, MembroService>();
builder.Services.AddScoped<MailService>();
builder.Services.AddCors(options =>
{
    options.AddPolicy(name: MyAllowSpecificOrigins,
        policy =>
        {
            policy.AllowAnyOrigin().AllowAnyHeader().AllowAnyMethod();
        });
});

var xmlFile = $"{Assembly.GetExecutingAssembly().GetName().Name}.xml";
var xmlPath = Path.Combine(AppContext.BaseDirectory, xmlFile);
builder.Services.AddSwaggerGen(c =>
{
    c.IncludeXmlComments(xmlPath);
});

builder.Services.AddDbContext<AppDbContext>(options =>
{
    options.UseNpgsql("Host=ep-empty-fire-acy9r612-pooler.sa-east-1.aws.neon.tech;Database=sistema_erp;Username=sistema_erp_owner;Password=npg_suTi30qUQZpL");
});

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}
app.UseCors(MyAllowSpecificOrigins);
app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
