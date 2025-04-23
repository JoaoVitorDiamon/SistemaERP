export async function buscarTiposDeEmpresa() {
    const response = await fetch('https://localhost:7106/api/TipoDeEmpresa');
    if (!response.ok) throw new Error('Erro ao buscar tipos de empresa');
    return response.json();
  }

  export async function buscarSetores() {
    const response = await fetch('https://localhost:7106/api/Setor');
    if (!response.ok) throw new Error('Erro ao buscar setores');
    return response.json();
  }
