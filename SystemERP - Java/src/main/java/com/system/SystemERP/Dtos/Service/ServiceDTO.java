package com.system.SystemERP.Dtos.Service;

import java.time.LocalTime;

public record ServiceDTO(
        String nome,                // Nome do serviço
        String etiqueta,            // Etiqueta do serviço
        boolean venda,              // Se o serviço está disponível para venda
        boolean compra,             // Se o serviço está disponível para compra
        String codigoDeBarras,     // Código de barras do serviço
        String descricao,           // Descrição do serviço
        String notas,               // Notas adicionais
        int duracaoHoras,           // Duração em horas
        int duracaoMinutos,         // Duração em minutos
        double preco,               // Preço do serviço
        double precoMinimo,         // Preço mínimo do serviço
        int icms,                   // ICMS do serviço
        double taxaCMSP             // Taxa CMSP do serviço
) {
    // Para retornar a duração como LocalTime
    public LocalTime getDuracao() {
        return LocalTime.of(duracaoHoras, duracaoMinutos);
    }
}
