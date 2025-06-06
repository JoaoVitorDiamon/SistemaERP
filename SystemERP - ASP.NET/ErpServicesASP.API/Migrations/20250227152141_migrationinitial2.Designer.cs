﻿// <auto-generated />
using System;
using ErpServicesASP.API.Data;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using Npgsql.EntityFrameworkCore.PostgreSQL.Metadata;

#nullable disable

namespace ErpServicesASP.API.Migrations
{
    [DbContext(typeof(AppDbContext))]
    [Migration("20250227152141_migrationinitial2")]
    partial class migrationinitial2
    {
        /// <inheritdoc />
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "8.0.3")
                .HasAnnotation("Relational:MaxIdentifierLength", 63);

            NpgsqlModelBuilderExtensions.UseIdentityByDefaultColumns(modelBuilder);

            modelBuilder.Entity("ErpServicesASP.API.Model.CargoModel", b =>
                {
                    b.Property<int>("idCargo")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("integer");

                    NpgsqlPropertyBuilderExtensions.UseIdentityByDefaultColumn(b.Property<int>("idCargo"));

                    b.Property<string>("Name")
                        .IsRequired()
                        .HasColumnType("text");

                    b.HasKey("idCargo");

                    b.ToTable("Cargos");
                });

            modelBuilder.Entity("ErpServicesASP.API.Model.EmpresaModel", b =>
                {
                    b.Property<int>("idEmpresa")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("integer");

                    NpgsqlPropertyBuilderExtensions.UseIdentityByDefaultColumn(b.Property<int>("idEmpresa"));

                    b.Property<string>("CEP")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<string>("CNPJ")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<DateTime>("DataCriacao")
                        .HasColumnType("timestamp without time zone");

                    b.Property<int>("DonoId")
                        .HasColumnType("integer");

                    b.Property<string>("Email")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<string>("Endereco")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<string>("Name")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<string>("NomeFantasia")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<int>("SetoridSetor")
                        .HasColumnType("integer");

                    b.Property<string>("Telefone")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<int>("TipoDeEmpresaidTipoDeEmpresa")
                        .HasColumnType("integer");

                    b.HasKey("idEmpresa");

                    b.HasIndex("DonoId");

                    b.HasIndex("SetoridSetor");

                    b.HasIndex("TipoDeEmpresaidTipoDeEmpresa");

                    b.ToTable("Empresas");
                });

            modelBuilder.Entity("ErpServicesASP.API.Model.MembroModel", b =>
                {
                    b.Property<int>("idMembro")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("integer");

                    NpgsqlPropertyBuilderExtensions.UseIdentityByDefaultColumn(b.Property<int>("idMembro"));

                    b.Property<string>("AssociacaoPublica")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<string>("CEP")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<int>("CargoidCargo")
                        .HasColumnType("integer");

                    b.Property<DateTime>("DataNascimento")
                        .HasColumnType("timestamp without time zone");

                    b.Property<int>("EmpresaidEmpresa")
                        .HasColumnType("integer");

                    b.Property<string>("Genero")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<string>("NaturezaMembro")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<string>("Telefone")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<int>("UsuarioId")
                        .HasColumnType("integer");

                    b.HasKey("idMembro");

                    b.HasIndex("CargoidCargo");

                    b.HasIndex("EmpresaidEmpresa");

                    b.HasIndex("UsuarioId");

                    b.ToTable("Membros");
                });

            modelBuilder.Entity("ErpServicesASP.API.Model.SetorModel", b =>
                {
                    b.Property<int>("idSetor")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("integer");

                    NpgsqlPropertyBuilderExtensions.UseIdentityByDefaultColumn(b.Property<int>("idSetor"));

                    b.Property<string>("Nome")
                        .IsRequired()
                        .HasColumnType("text");

                    b.HasKey("idSetor");

                    b.ToTable("Setores");
                });

            modelBuilder.Entity("ErpServicesASP.API.Model.TipoDeEmpresaModel", b =>
                {
                    b.Property<int>("idTipoDeEmpresa")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("integer");

                    NpgsqlPropertyBuilderExtensions.UseIdentityByDefaultColumn(b.Property<int>("idTipoDeEmpresa"));

                    b.Property<string>("Name")
                        .IsRequired()
                        .HasColumnType("text");

                    b.HasKey("idTipoDeEmpresa");

                    b.ToTable("TipoDeEmpresa");
                });

            modelBuilder.Entity("ErpServicesASP.API.Model.UsuarioModel", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("integer");

                    NpgsqlPropertyBuilderExtensions.UseIdentityByDefaultColumn(b.Property<int>("Id"));

                    b.Property<string>("CPF")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<DateTime>("DataCriacao")
                        .HasColumnType("timestamp without time zone");

                    b.Property<string>("Email")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<string>("Name")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<string>("Senha")
                        .IsRequired()
                        .HasColumnType("text");

                    b.HasKey("Id");

                    b.ToTable("Usuarios");
                });

            modelBuilder.Entity("ErpServicesASP.API.Model.ValidacaoEmailModel", b =>
                {
                    b.Property<int>("idValidacaoEmail")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("integer");

                    NpgsqlPropertyBuilderExtensions.UseIdentityByDefaultColumn(b.Property<int>("idValidacaoEmail"));

                    b.Property<string>("Codigo")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<int>("UsuarioId")
                        .HasColumnType("integer");

                    b.Property<bool>("Validado")
                        .HasColumnType("boolean");

                    b.HasKey("idValidacaoEmail");

                    b.HasIndex("UsuarioId");

                    b.ToTable("ValidacoesDeEmails");
                });

            modelBuilder.Entity("ErpServicesASP.API.Model.EmpresaModel", b =>
                {
                    b.HasOne("ErpServicesASP.API.Model.UsuarioModel", "Dono")
                        .WithMany()
                        .HasForeignKey("DonoId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("ErpServicesASP.API.Model.SetorModel", "Setor")
                        .WithMany()
                        .HasForeignKey("SetoridSetor")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("ErpServicesASP.API.Model.TipoDeEmpresaModel", "TipoDeEmpresa")
                        .WithMany()
                        .HasForeignKey("TipoDeEmpresaidTipoDeEmpresa")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Dono");

                    b.Navigation("Setor");

                    b.Navigation("TipoDeEmpresa");
                });

            modelBuilder.Entity("ErpServicesASP.API.Model.MembroModel", b =>
                {
                    b.HasOne("ErpServicesASP.API.Model.CargoModel", "Cargo")
                        .WithMany()
                        .HasForeignKey("CargoidCargo")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("ErpServicesASP.API.Model.EmpresaModel", "Empresa")
                        .WithMany()
                        .HasForeignKey("EmpresaidEmpresa")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("ErpServicesASP.API.Model.UsuarioModel", "Usuario")
                        .WithMany()
                        .HasForeignKey("UsuarioId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Cargo");

                    b.Navigation("Empresa");

                    b.Navigation("Usuario");
                });

            modelBuilder.Entity("ErpServicesASP.API.Model.ValidacaoEmailModel", b =>
                {
                    b.HasOne("ErpServicesASP.API.Model.UsuarioModel", "Usuario")
                        .WithMany()
                        .HasForeignKey("UsuarioId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Usuario");
                });
#pragma warning restore 612, 618
        }
    }
}
