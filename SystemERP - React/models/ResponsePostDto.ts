export interface ResponsePostDto {
    valor: {
        id: number
        name: string
        cpf: string
        email: string
        dataCriacao: string
    }
    mensagem?: string
    status: boolean
}