package br.com.bluebank.service.accountHolder;

import br.com.bluebank.model.dto.accountholder.AccountHolderDTO;
import br.com.bluebank.model.dto.accountholder.CreateAccountHolderDTO;
import br.com.bluebank.model.dto.bankTransfer.TransactionDTO;
import br.com.bluebank.model.enums.TransactionType;
import br.com.bluebank.model.exceptions.AccountHolderAlreadyExistsException;
import br.com.bluebank.model.exceptions.AccountHolderNotFoundException;

public interface AccountHolderService {

    void saveAccountHolder(CreateAccountHolderDTO dto) throws AccountHolderAlreadyExistsException;
    AccountHolderDTO findAccountHolder(Long accountHolderId) throws AccountHolderNotFoundException;
    AccountHolderDTO updateAccountHolder(AccountHolderDTO dto, Long accountHolderId);
    TransactionDTO bankTransaction(Long accountHolderId, Double amount, TransactionType type) throws AccountHolderNotFoundException;
}
