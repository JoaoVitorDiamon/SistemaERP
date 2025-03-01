using System;
using Microsoft.EntityFrameworkCore.Migrations;
using Npgsql.EntityFrameworkCore.PostgreSQL.Metadata;

#nullable disable

namespace ErpServicesASP.API.Migrations
{
    /// <inheritdoc />
    public partial class Testando87 : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Membros");

            migrationBuilder.DropTable(
                name: "Empresas");

            migrationBuilder.DropTable(
                name: "Setores");

            migrationBuilder.DropTable(
                name: "TipoDeEmpresa");

            migrationBuilder.DropTable(
                name: "Usuarios");

            migrationBuilder.CreateTable(
                name: "armazem",
                columns: table => new
                {
                    id_armazem = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    nome = table.Column<string>(type: "text", nullable: false),
                    descricao = table.Column<string>(type: "text", nullable: false),
                    telefone = table.Column<string>(type: "text", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_armazem", x => x.id_armazem);
                });

            migrationBuilder.CreateTable(
                name: "EnterpriseTypes",
                columns: table => new
                {
                    idTipoDeEmpresa = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    Name = table.Column<string>(type: "text", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_EnterpriseTypes", x => x.idTipoDeEmpresa);
                });

            migrationBuilder.CreateTable(
                name: "Sectors",
                columns: table => new
                {
                    idSetor = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    Nome = table.Column<string>(type: "text", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Sectors", x => x.idSetor);
                });

            migrationBuilder.CreateTable(
                name: "terceiros",
                columns: table => new
                {
                    idTerceiros = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    nome = table.Column<string>(type: "character varying(255)", maxLength: 255, nullable: false),
                    nomeEFantasia = table.Column<string>(type: "character varying(255)", maxLength: 255, nullable: false),
                    fornecedor = table.Column<bool>(type: "boolean", nullable: false),
                    estadoAtividade = table.Column<bool>(type: "boolean", nullable: false),
                    email = table.Column<string>(type: "character varying(255)", maxLength: 255, nullable: false),
                    impostoSobVenda = table.Column<bool>(type: "boolean", nullable: false),
                    segundoImposto = table.Column<bool>(type: "boolean", nullable: false),
                    capital = table.Column<double>(type: "numeric(18,2)", nullable: false),
                    quantidadeColaboradores = table.Column<int>(type: "integer", nullable: false),
                    logotipo = table.Column<byte[]>(type: "bytea", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_terceiros", x => x.idTerceiros);
                });

            migrationBuilder.CreateTable(
                name: "Users",
                columns: table => new
                {
                    Id = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    Name = table.Column<string>(type: "text", nullable: false),
                    CPF = table.Column<string>(type: "text", nullable: false),
                    Email = table.Column<string>(type: "text", nullable: false),
                    Senha = table.Column<string>(type: "text", nullable: false),
                    DataCriacao = table.Column<DateTime>(type: "timestamp without time zone", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Users", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Enterprises",
                columns: table => new
                {
                    IdEmpresa = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    Name = table.Column<string>(type: "text", nullable: false),
                    FantasyName = table.Column<string>(type: "text", nullable: false),
                    OwnerId = table.Column<int>(type: "integer", nullable: false),
                    CNPJ = table.Column<string>(type: "text", nullable: false),
                    Email = table.Column<string>(type: "text", nullable: false),
                    EnterpriseTypeidTipoDeEmpresa = table.Column<int>(type: "integer", nullable: false),
                    SectoridSetor = table.Column<int>(type: "integer", nullable: false),
                    CreationDate = table.Column<DateTime>(type: "timestamp without time zone", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Enterprises", x => x.IdEmpresa);
                    table.ForeignKey(
                        name: "FK_Enterprises_EnterpriseTypes_EnterpriseTypeidTipoDeEmpresa",
                        column: x => x.EnterpriseTypeidTipoDeEmpresa,
                        principalTable: "EnterpriseTypes",
                        principalColumn: "idTipoDeEmpresa",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Enterprises_Sectors_SectoridSetor",
                        column: x => x.SectoridSetor,
                        principalTable: "Sectors",
                        principalColumn: "idSetor",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Enterprises_Users_OwnerId",
                        column: x => x.OwnerId,
                        principalTable: "Users",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "Addresses",
                columns: table => new
                {
                    IdAdress = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    Country = table.Column<string>(type: "text", nullable: false),
                    CEP = table.Column<string>(type: "text", nullable: false),
                    State = table.Column<string>(type: "text", nullable: false),
                    City = table.Column<string>(type: "text", nullable: false),
                    Neighborhood = table.Column<string>(type: "text", nullable: false),
                    Street = table.Column<string>(type: "text", nullable: false),
                    Number = table.Column<string>(type: "text", nullable: false),
                    Complement = table.Column<string>(type: "text", nullable: false),
                    EnterpriseIdEmpresa = table.Column<int>(type: "integer", nullable: false),
                    ThirdidTerceiros = table.Column<int>(type: "integer", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Addresses", x => x.IdAdress);
                    table.ForeignKey(
                        name: "FK_Addresses_Enterprises_EnterpriseIdEmpresa",
                        column: x => x.EnterpriseIdEmpresa,
                        principalTable: "Enterprises",
                        principalColumn: "IdEmpresa",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Addresses_terceiros_ThirdidTerceiros",
                        column: x => x.ThirdidTerceiros,
                        principalTable: "terceiros",
                        principalColumn: "idTerceiros",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "Members",
                columns: table => new
                {
                    idMembro = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    EmpresaIdEmpresa = table.Column<int>(type: "integer", nullable: false),
                    UsuarioId = table.Column<int>(type: "integer", nullable: false),
                    CargoidCargo = table.Column<int>(type: "integer", nullable: false),
                    NaturezaMembro = table.Column<string>(type: "text", nullable: false),
                    Genero = table.Column<string>(type: "text", nullable: false),
                    AddressIdAdress = table.Column<int>(type: "integer", nullable: false),
                    DataNascimento = table.Column<DateTime>(type: "timestamp without time zone", nullable: false),
                    AssociacaoPublica = table.Column<string>(type: "text", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Members", x => x.idMembro);
                    table.ForeignKey(
                        name: "FK_Members_Addresses_AddressIdAdress",
                        column: x => x.AddressIdAdress,
                        principalTable: "Addresses",
                        principalColumn: "IdAdress",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Members_Cargos_CargoidCargo",
                        column: x => x.CargoidCargo,
                        principalTable: "Cargos",
                        principalColumn: "idCargo",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Members_Enterprises_EmpresaIdEmpresa",
                        column: x => x.EmpresaIdEmpresa,
                        principalTable: "Enterprises",
                        principalColumn: "IdEmpresa",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Members_Users_UsuarioId",
                        column: x => x.UsuarioId,
                        principalTable: "Users",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "Telephones",
                columns: table => new
                {
                    IdTelephone = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    Number = table.Column<string>(type: "text", nullable: false),
                    EnterpriseIdEmpresa = table.Column<int>(type: "integer", nullable: false),
                    ThirdidTerceiros = table.Column<int>(type: "integer", nullable: false),
                    MemberidMembro = table.Column<int>(type: "integer", nullable: false),
                    Storageid_armazem = table.Column<int>(type: "integer", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Telephones", x => x.IdTelephone);
                    table.ForeignKey(
                        name: "FK_Telephones_Enterprises_EnterpriseIdEmpresa",
                        column: x => x.EnterpriseIdEmpresa,
                        principalTable: "Enterprises",
                        principalColumn: "IdEmpresa",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Telephones_Members_MemberidMembro",
                        column: x => x.MemberidMembro,
                        principalTable: "Members",
                        principalColumn: "idMembro",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Telephones_armazem_Storageid_armazem",
                        column: x => x.Storageid_armazem,
                        principalTable: "armazem",
                        principalColumn: "id_armazem",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Telephones_terceiros_ThirdidTerceiros",
                        column: x => x.ThirdidTerceiros,
                        principalTable: "terceiros",
                        principalColumn: "idTerceiros",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Addresses_EnterpriseIdEmpresa",
                table: "Addresses",
                column: "EnterpriseIdEmpresa");

            migrationBuilder.CreateIndex(
                name: "IX_Addresses_ThirdidTerceiros",
                table: "Addresses",
                column: "ThirdidTerceiros");

            migrationBuilder.CreateIndex(
                name: "IX_Enterprises_EnterpriseTypeidTipoDeEmpresa",
                table: "Enterprises",
                column: "EnterpriseTypeidTipoDeEmpresa");

            migrationBuilder.CreateIndex(
                name: "IX_Enterprises_OwnerId",
                table: "Enterprises",
                column: "OwnerId");

            migrationBuilder.CreateIndex(
                name: "IX_Enterprises_SectoridSetor",
                table: "Enterprises",
                column: "SectoridSetor");

            migrationBuilder.CreateIndex(
                name: "IX_Members_AddressIdAdress",
                table: "Members",
                column: "AddressIdAdress");

            migrationBuilder.CreateIndex(
                name: "IX_Members_CargoidCargo",
                table: "Members",
                column: "CargoidCargo");

            migrationBuilder.CreateIndex(
                name: "IX_Members_EmpresaIdEmpresa",
                table: "Members",
                column: "EmpresaIdEmpresa");

            migrationBuilder.CreateIndex(
                name: "IX_Members_UsuarioId",
                table: "Members",
                column: "UsuarioId");

            migrationBuilder.CreateIndex(
                name: "IX_Telephones_EnterpriseIdEmpresa",
                table: "Telephones",
                column: "EnterpriseIdEmpresa");

            migrationBuilder.CreateIndex(
                name: "IX_Telephones_MemberidMembro",
                table: "Telephones",
                column: "MemberidMembro");

            migrationBuilder.CreateIndex(
                name: "IX_Telephones_Storageid_armazem",
                table: "Telephones",
                column: "Storageid_armazem");

            migrationBuilder.CreateIndex(
                name: "IX_Telephones_ThirdidTerceiros",
                table: "Telephones",
                column: "ThirdidTerceiros");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Telephones");

            migrationBuilder.DropTable(
                name: "Members");

            migrationBuilder.DropTable(
                name: "armazem");

            migrationBuilder.DropTable(
                name: "Addresses");

            migrationBuilder.DropTable(
                name: "Enterprises");

            migrationBuilder.DropTable(
                name: "terceiros");

            migrationBuilder.DropTable(
                name: "EnterpriseTypes");

            migrationBuilder.DropTable(
                name: "Sectors");

            migrationBuilder.DropTable(
                name: "Users");

            migrationBuilder.CreateTable(
                name: "Setores",
                columns: table => new
                {
                    idSetor = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    Nome = table.Column<string>(type: "text", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Setores", x => x.idSetor);
                });

            migrationBuilder.CreateTable(
                name: "TipoDeEmpresa",
                columns: table => new
                {
                    idTipoDeEmpresa = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    Name = table.Column<string>(type: "text", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_TipoDeEmpresa", x => x.idTipoDeEmpresa);
                });

            migrationBuilder.CreateTable(
                name: "Usuarios",
                columns: table => new
                {
                    Id = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    CPF = table.Column<string>(type: "text", nullable: false),
                    DataCriacao = table.Column<DateTime>(type: "timestamp without time zone", nullable: false),
                    Email = table.Column<string>(type: "text", nullable: false),
                    Name = table.Column<string>(type: "text", nullable: false),
                    Senha = table.Column<string>(type: "text", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Usuarios", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Empresas",
                columns: table => new
                {
                    idEmpresa = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    DonoId = table.Column<int>(type: "integer", nullable: false),
                    SetoridSetor = table.Column<int>(type: "integer", nullable: false),
                    TipoDeEmpresaidTipoDeEmpresa = table.Column<int>(type: "integer", nullable: false),
                    CEP = table.Column<string>(type: "text", nullable: false),
                    CNPJ = table.Column<string>(type: "text", nullable: false),
                    DataCriacao = table.Column<DateTime>(type: "timestamp without time zone", nullable: false),
                    Email = table.Column<string>(type: "text", nullable: false),
                    Endereco = table.Column<string>(type: "text", nullable: false),
                    Name = table.Column<string>(type: "text", nullable: false),
                    NomeFantasia = table.Column<string>(type: "text", nullable: false),
                    Telefone = table.Column<string>(type: "text", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Empresas", x => x.idEmpresa);
                    table.ForeignKey(
                        name: "FK_Empresas_Setores_SetoridSetor",
                        column: x => x.SetoridSetor,
                        principalTable: "Setores",
                        principalColumn: "idSetor",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Empresas_TipoDeEmpresa_TipoDeEmpresaidTipoDeEmpresa",
                        column: x => x.TipoDeEmpresaidTipoDeEmpresa,
                        principalTable: "TipoDeEmpresa",
                        principalColumn: "idTipoDeEmpresa",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Empresas_Usuarios_DonoId",
                        column: x => x.DonoId,
                        principalTable: "Usuarios",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "ValidacoesDeEmails",
                columns: table => new
                {
                    idValidacaoEmail = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    UsuarioId = table.Column<int>(type: "integer", nullable: false),
                    Codigo = table.Column<string>(type: "text", nullable: false),
                    Validado = table.Column<bool>(type: "boolean", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_ValidacoesDeEmails", x => x.idValidacaoEmail);
                    table.ForeignKey(
                        name: "FK_ValidacoesDeEmails_Usuarios_UsuarioId",
                        column: x => x.UsuarioId,
                        principalTable: "Usuarios",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "Membros",
                columns: table => new
                {
                    idMembro = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    CargoidCargo = table.Column<int>(type: "integer", nullable: false),
                    EmpresaidEmpresa = table.Column<int>(type: "integer", nullable: false),
                    UsuarioId = table.Column<int>(type: "integer", nullable: false),
                    AssociacaoPublica = table.Column<string>(type: "text", nullable: false),
                    CEP = table.Column<string>(type: "text", nullable: false),
                    DataNascimento = table.Column<DateTime>(type: "timestamp without time zone", nullable: false),
                    Genero = table.Column<string>(type: "text", nullable: false),
                    NaturezaMembro = table.Column<string>(type: "text", nullable: false),
                    Telefone = table.Column<string>(type: "text", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Membros", x => x.idMembro);
                    table.ForeignKey(
                        name: "FK_Membros_Cargos_CargoidCargo",
                        column: x => x.CargoidCargo,
                        principalTable: "Cargos",
                        principalColumn: "idCargo",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Membros_Empresas_EmpresaidEmpresa",
                        column: x => x.EmpresaidEmpresa,
                        principalTable: "Empresas",
                        principalColumn: "idEmpresa",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Membros_Usuarios_UsuarioId",
                        column: x => x.UsuarioId,
                        principalTable: "Usuarios",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Empresas_DonoId",
                table: "Empresas",
                column: "DonoId");

            migrationBuilder.CreateIndex(
                name: "IX_Empresas_SetoridSetor",
                table: "Empresas",
                column: "SetoridSetor");

            migrationBuilder.CreateIndex(
                name: "IX_Empresas_TipoDeEmpresaidTipoDeEmpresa",
                table: "Empresas",
                column: "TipoDeEmpresaidTipoDeEmpresa");

            migrationBuilder.CreateIndex(
                name: "IX_Membros_CargoidCargo",
                table: "Membros",
                column: "CargoidCargo");

            migrationBuilder.CreateIndex(
                name: "IX_Membros_EmpresaidEmpresa",
                table: "Membros",
                column: "EmpresaidEmpresa");

            migrationBuilder.CreateIndex(
                name: "IX_Membros_UsuarioId",
                table: "Membros",
                column: "UsuarioId");

            migrationBuilder.CreateIndex(
                name: "IX_ValidacoesDeEmails_UsuarioId",
                table: "ValidacoesDeEmails",
                column: "UsuarioId");
        }
    }
}
