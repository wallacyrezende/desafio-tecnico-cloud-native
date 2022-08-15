package br.com.bluebank.service.transaction;

import br.com.bluebank.model.dto.bankTransfer.BankTransactionDTO;
import br.com.bluebank.model.exceptions.AccountHolderNotFoundException;
import br.com.bluebank.model.exceptions.BusinessRuleException;

public interface TransactionService {

    void transfer(BankTransactionDTO dto) throws AccountHolderNotFoundException, BusinessRuleException;
    void debitAmount(Long accountHolderId, Double amount) throws AccountHolderNotFoundException;
    void creditAmount(Long accountHolderId, Double amount) throws AccountHolderNotFoundException;
}
