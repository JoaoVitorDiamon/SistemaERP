import { EmpresaCreateDto } from "../../../models/EmpresaCreateDto";
import { ResponsePostDto } from "../../../models/ResponsePostDto";

export async function verificarCPF(cpf: string): Promise<boolean> {
  const response = await fetch(`https://localhost:7106/api/Usuario/CPF/${cpf}`);
  const result = await response.json();
  return result.valor === "Usado";
}

export async function verificarEmail(email: string): Promise<boolean> {
  const response = await fetch(`https://localhost:7106/api/Usuario/Email/${email}`);
  const result = await response.json();
  return result.valor === "Usado";
}

export async function criarRepresentante(representante: {
  Name: string;
  CPF: string;
  EmailRepresentante: string;
  Senha: string;
}): Promise<ResponsePostDto> {
  const response = await fetch(`https://localhost:7106/api/Usuario`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      Name: representante.Name,
      CPF: representante.CPF,
      Email: representante.EmailRepresentante,
      Senha: representante.Senha,
    })
  });
  return await response.json();
}

export async function criarEmpresa(empresa: EmpresaCreateDto): Promise<void> {
  const response = await fetch(`https://localhost:7106/api/Empresa`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(empresa)
  });
  const result = await response.json();
  console.log(result);
}
