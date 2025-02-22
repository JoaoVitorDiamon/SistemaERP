package com.system.SystemERP.Dtos.AccountingCode;

import com.system.SystemERP.Enum.AccountingCode.AccountingCodeDescriptionEnum;
import com.system.SystemERP.Enum.AccountingCode.AccountingCodeEnum;

public record AccountingCodeDTO(AccountingCodeEnum accountingCode, AccountingCodeDescriptionEnum accountingCodeDescription) {
}
