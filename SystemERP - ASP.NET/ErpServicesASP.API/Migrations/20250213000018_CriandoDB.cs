using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace ErpServicesASP.API.Migrations
{
    /// <inheritdoc />
    public partial class CriandoDB : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Cargos",
                columns: table => new
                {
                    idCargo = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Name = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Cargos", x => x.idCargo);
                });

            migrationBuilder.CreateTable(
                name: "TipoDeEmpresa",
                columns: table => new
                {
                    idTipoDeEmpresa = table.Column<string>(type: "nvarchar(450)", nullable: false),
                    Name = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_TipoDeEmpresa", x => x.idTipoDeEmpresa);
                });

            migrationBuilder.CreateTable(
                name: "Usuarios",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Name = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Telefone = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Email = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Genero = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    DataCriacao = table.Column<DateOnly>(type: "date", nullable: false),
                    CEP = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Endereco = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    DataNascimento = table.Column<DateOnly>(type: "date", nullable: false),
                    AssociacaoPublica = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Usuarios", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Empresas",
                columns: table => new
                {
                    idEmpresa = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Name = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    NomeFantasia = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    DonoId = table.Column<int>(type: "int", nullable: false),
                    CNPJ = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Email = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Telefone = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Endereco = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    TipoDeEmpresaidTipoDeEmpresa = table.Column<string>(type: "nvarchar(450)", nullable: false),
                    DataCriacao = table.Column<DateOnly>(type: "date", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Empresas", x => x.idEmpresa);
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
                name: "Membros",
                columns: table => new
                {
                    idMembro = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    EmpresaidEmpresa = table.Column<int>(type: "int", nullable: false),
                    UsuarioId = table.Column<int>(type: "int", nullable: false),
                    CargoidCargo = table.Column<int>(type: "int", nullable: false),
                    NaturezaMembro = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    EmailDaEmpresa = table.Column<string>(type: "nvarchar(max)", nullable: false)
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
                        onDelete: ReferentialAction.NoAction);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Empresas_DonoId",
                table: "Empresas",
                column: "DonoId");

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
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Membros");

            migrationBuilder.DropTable(
                name: "Cargos");

            migrationBuilder.DropTable(
                name: "Empresas");

            migrationBuilder.DropTable(
                name: "TipoDeEmpresa");

            migrationBuilder.DropTable(
                name: "Usuarios");
        }
    }
}
