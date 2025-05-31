using ErpServicesASP.API.Data;
using ErpServicesASP.API.Repositories;
using ErpServicesASP.API.Repositories.Interfaces;
using ErpServicesASP.API.Services;
using ErpServicesASP.API.Services.Interfaces;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.EntityFrameworkCore;
using System.Reflection;

var builder = WebApplication.CreateBuilder(args);
var MyAllowSpecificOrigins = "_MyAllowSubdomainPolicy";
// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddScoped<ICargoRepository, RoleRepository>();
builder.Services.AddScoped<IUsuarioRepository, UsuarioRepository>();
//builder.Services.AddScoped<IValidacaoEmailRepository, ValidacaoEmailRepository>();
builder.Services.AddScoped<IUsuarioService, UsuarioService>();
//builder.Services.AddScoped<IValidacaoEmailService, ValidacaoEmailService>();
builder.Services.AddScoped<ITipoDeEmpresaRepository, TipoDeEmpresaRepository>();
builder.Services.AddScoped<ITipoDeEmpresaService, TipoDeEmpresaService>();
builder.Services.AddScoped<ISetorEmpresaRepository, SetorEmpresaRepository>();
builder.Services.AddScoped<ISetorEmpresaService, SetorDeEmpresaService>();
builder.Services.AddScoped<IEmpresaRepository, EmpresaRepository>();
builder.Services.AddScoped<IEmpresaService, EmpresaService>();
builder.Services.AddScoped<IMembroRepository, MemberRepository>();
builder.Services.AddScoped<IAddressRepository, AddressRepository>();
builder.Services.AddScoped<IAddressService, AddressService>();
builder.Services.AddScoped<IMembroService, MembroService>();
builder.Services.AddScoped<ITokenInterface, TokenService>();
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
    options.UseNpgsql("Host=ep-green-flower-acwa0b59-pooler.sa-east-1.aws.neon.tech;Database=sistema_erp;Username=sistema_erp_owner;Password=npg_suTi30qUQZpL;SSL Mode=Require;Trust Server Certificate=true");
});

var key = System.Text.Encoding.UTF8.GetBytes("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkV4ZW1wbG8gVXN1YXJpbyIsImlhdCI6MTYxNjIwMDAwMH0SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c");
builder.Services.AddAuthentication(aut =>
{
    aut.DefaultAuthenticateScheme = JwtBearerDefaults.AuthenticationScheme;
    aut.DefaultChallengeScheme = JwtBearerDefaults.AuthenticationScheme;
}).AddJwtBearer(config => { 
    config.RequireHttpsMetadata = true;
    config.SaveToken = true;
    config.TokenValidationParameters = new Microsoft.IdentityModel.Tokens.TokenValidationParameters
    {
        ValidateIssuerSigningKey = true,
        IssuerSigningKey = new Microsoft.IdentityModel.Tokens.SymmetricSecurityKey(key),
        ValidateIssuer = false,
        ValidateAudience = false
    };
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

app.UseAuthentication();
app.UseAuthorization();

app.MapControllers();

app.Run();
