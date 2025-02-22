package com.system.SystemERP.Enum.PaymentTerms;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(hidden = true)
public enum PaymentTermsEnum {
        Apos_o_Recebimento,
        Trinta_dias,
        Trinta_dias_depois_do_fim_do_mes,
        Sessenta_dias,
        Sessenta_dias_depois_do_fim_do_mes,
        pedido,
        Na_Entrega,
        cinquenta_cinquenta,
}
