using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace ErpServicesASP.API.Migrations
{
    /// <inheritdoc />
    public partial class atualizando3 : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "CEP",
                table: "Empresas",
                type: "longtext",
                nullable: false)
                .Annotation("MySql:CharSet", "utf8mb4");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "CEP",
                table: "Empresas");
        }
    }
}
