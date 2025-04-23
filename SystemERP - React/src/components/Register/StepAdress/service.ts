export interface ICep {
    cep: string;
    logradouro: string;
    complemento: string;
    localidade: string;
    bairro: string;
    estado: string;
    numero: string;
  }

  export async function buscarEnderecoPorCep(cep: string): Promise<ICep | null> {
    try {
      const response = await fetch(`https://localhost:7106/api/Empresa/cep/${cep}`, {
        method: "GET",
        headers: { "Content-Type": "application/json" },
      });

      if (!response.ok) throw new Error("Erro ao buscar CEP");

      const data = await response.json();
      return data;
    } catch (error) {
      console.error("Erro ao buscar endereço:", error);
      return null;
    }
  }
