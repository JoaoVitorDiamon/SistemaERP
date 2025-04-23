export async function jaExisteCNPJ(cnpj = ""): Promise<boolean> {
    const response = await fetch(`https://localhost:7106/api/Empresa/CNPJ/${cnpj}`);
    const data = await response.json();
    return data.valor === "Usado";
  }

  export async function jaExisteEmail(email = ""): Promise<boolean> {
    const response = await fetch(`https://localhost:7106/api/Empresa/Email/${email}`);
    const data = await response.json();
    return data.valor === "Usado";
  }
