export interface EmpresaCreateDto {
    name: string
    nomeFantasia?: string
    idDono?: number
    cnpj: string
    email: string
    setor?: string
    telefone?: string
    endereco?: string
    idTipoDeEmpresa?: number
    dataCriacao?: string
  }