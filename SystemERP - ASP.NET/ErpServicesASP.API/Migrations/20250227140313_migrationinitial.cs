using System;
using Microsoft.EntityFrameworkCore.Migrations;
using Npgsql.EntityFrameworkCore.PostgreSQL.Metadata;

#nullable disable

namespace ErpServicesASP.API.Migrations
{
    /// <inheritdoc />
    public partial class migrationinitial : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Cargos",
                columns: table => new
                {
                    idCargo = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    Name = table.Column<string>(type: "text", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Cargos", x => x.idCargo);
                });

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
                    Name = table.Column<string>(type: "text", nullable: false),
                    CPF = table.Column<string>(type: "text", nullable: false),
                    Email = table.Column<string>(type: "text", nullable: false),
                    DataCriacao = table.Column<DateTime>(type: "timestamp with time zone", nullable: false)
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
                    Name = table.Column<string>(type: "text", nullable: false),
                    NomeFantasia = table.Column<string>(type: "text", nullable: false),
                    DonoId = table.Column<int>(type: "integer", nullable: false),
                    CNPJ = table.Column<string>(type: "text", nullable: false),
                    Email = table.Column<string>(type: "text", nullable: false),
                    Telefone = table.Column<string>(type: "text", nullable: false),
                    Endereco = table.Column<string>(type: "text", nullable: false),
                    CEP = table.Column<string>(type: "text", nullable: false),
                    TipoDeEmpresaidTipoDeEmpresa = table.Column<int>(type: "integer", nullable: false),
                    SetoridSetor = table.Column<int>(type: "integer", nullable: false),
                    DataCriacao = table.Column<DateTime>(type: "timestamp with time zone", nullable: false)
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
                    Codigo = table.Column<string>(type: "text", nullable: false),
                    UsuarioId = table.Column<int>(type: "integer", nullable: false),
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
                    EmpresaidEmpresa = table.Column<int>(type: "integer", nullable: false),
                    UsuarioId = table.Column<int>(type: "integer", nullable: false),
                    CargoidCargo = table.Column<int>(type: "integer", nullable: false),
                    NaturezaMembro = table.Column<string>(type: "text", nullable: false),
                    Genero = table.Column<string>(type: "text", nullable: false),
                    Telefone = table.Column<string>(type: "text", nullable: false),
                    Senha = table.Column<string>(type: "text", nullable: false),
                    CEP = table.Column<string>(type: "text", nullable: false),
                    DataNascimento = table.Column<DateTime>(type: "timestamp with time zone", nullable: false),
                    AssociacaoPublica = table.Column<string>(type: "text", nullable: false)
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

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Membros");

            migrationBuilder.DropTable(
                name: "ValidacoesDeEmails");

            migrationBuilder.DropTable(
                name: "Cargos");

            migrationBuilder.DropTable(
                name: "Empresas");

            migrationBuilder.DropTable(
                name: "Setores");

            migrationBuilder.DropTable(
                name: "TipoDeEmpresa");

            migrationBuilder.DropTable(
                name: "Usuarios");
        }
    }
}
