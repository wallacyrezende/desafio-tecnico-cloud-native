package br.com.bluebank.model.dto.bankTransfer;

import com.sun.istack.NotNull;
import lombok.Getter;

@Getter
public class BankTransactionDTO {

    @NotNull
    private Long fromAccountHolderId;
    private Long toAccountHolderId;
    @NotNull
    private Double amount;
}
