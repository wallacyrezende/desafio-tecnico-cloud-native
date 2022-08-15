package br.com.bluebank.model.dto.bankTransfer;

import br.com.bluebank.model.entities.AccountHolder;
import br.com.bluebank.model.enums.TransactionType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TransactionDTO {
    private Double amount;
    private AccountHolder accountHolder;
    private TransactionType type;
}
