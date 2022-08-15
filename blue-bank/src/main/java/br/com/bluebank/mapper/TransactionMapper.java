package br.com.bluebank.mapper;

import br.com.bluebank.model.dto.bankTransfer.TransactionDTO;
import br.com.bluebank.model.dto.bankTransfer.BankTransactionDTO;
import br.com.bluebank.model.entities.AccountHolder;
import br.com.bluebank.model.entities.Transaction;
import br.com.bluebank.model.enums.TransactionType;
import br.com.bluebank.model.exceptions.NullOrEmptyObjectException;
import br.com.bluebank.model.exceptions.utils.NullOrEmptyFieldException;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper extends Mapper {

    public static Transaction buildTransaction(AccountHolder accountHolder, TransactionType transactionType, Double amount) {

        if(isNull(accountHolder)) {
            throw new NullOrEmptyObjectException(AccountHolder.class.getSimpleName());
        }

        if(isNull(transactionType)) {
            throw new NullOrEmptyObjectException(TransactionType.class.getSimpleName());
        }

        if(isNull(amount)) {
            throw new NullOrEmptyFieldException("amount");
        }

        return Transaction.builder()
                .amount(amount)
                .accountHolder(accountHolder)
                .type(transactionType)
                .build();
    }

    public static TransactionDTO buildTransactionDTO(AccountHolder accountHolder, TransactionType transactionType, Double amount) {

        if(isNull(accountHolder)) {
            throw new NullOrEmptyObjectException(AccountHolder.class.getSimpleName());
        }

        if(isNull(transactionType)) {
            throw new NullOrEmptyObjectException(TransactionType.class.getSimpleName());
        }

        if(isNull(amount)) {
            throw new NullOrEmptyFieldException("amount");
        }

        return TransactionDTO.builder()
                .amount(amount)
                .accountHolder(accountHolder)
                .type(transactionType)
                .build();
    }
}
