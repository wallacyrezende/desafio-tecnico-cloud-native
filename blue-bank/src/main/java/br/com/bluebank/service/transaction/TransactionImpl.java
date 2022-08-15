package br.com.bluebank.service.transaction;

import br.com.bluebank.mapper.TransactionMapper;
import br.com.bluebank.model.dto.accountholder.AccountHolderDTO;
import br.com.bluebank.model.dto.bankTransfer.TransactionDTO;
import br.com.bluebank.model.dto.bankTransfer.BankTransactionDTO;
import br.com.bluebank.model.entities.Transaction;
import br.com.bluebank.model.enums.ErrorCode;
import br.com.bluebank.model.enums.TransactionType;
import br.com.bluebank.model.exceptions.AccountHolderNotFoundException;
import br.com.bluebank.model.exceptions.BusinessRuleException;
import br.com.bluebank.repository.transaction.TransactionRepository;
import br.com.bluebank.service.accountHolder.AccountHolderService;
import org.springframework.stereotype.Service;

@Service
public class TransactionImpl implements TransactionService {

    private final AccountHolderService accountHolderService;
    private final TransactionRepository transactionRepository;

    public TransactionImpl(AccountHolderService accountHolderService, TransactionRepository transactionRepository) {
        this.accountHolderService = accountHolderService;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void transfer(BankTransactionDTO dto) throws AccountHolderNotFoundException, BusinessRuleException {
        verifyBalanceFromAccountHolder(accountHolderService.findAccountHolder(dto.getFromAccountHolderId()), dto.getAmount());
        debitAmount(dto.getFromAccountHolderId(), dto.getAmount());
        creditAmount(dto.getToAccountHolderId(), dto.getAmount());
    }

    @Override
    public void debitAmount(Long accountHolderId, Double amount) throws AccountHolderNotFoundException {
        TransactionDTO transactionDTO =  accountHolderService.bankTransaction(accountHolderId, amount, TransactionType.DEBIT);
        Transaction transaction = TransactionMapper.buildTransaction(transactionDTO.getAccountHolder(), transactionDTO.getType(), amount);
        transactionRepository.save(transaction);
    }

    @Override
    public void creditAmount(Long accountHolderId, Double amount) throws AccountHolderNotFoundException {
        TransactionDTO transactionDTO =  accountHolderService.bankTransaction(accountHolderId, amount, TransactionType.CREDIT);
        Transaction transaction = TransactionMapper.buildTransaction(transactionDTO.getAccountHolder(), transactionDTO.getType(), amount);
        transactionRepository.save(transaction);
    }

    private void verifyBalanceFromAccountHolder(AccountHolderDTO fromAccountHolder, Double amount) throws BusinessRuleException {
       if(fromAccountHolder.getBalance() < amount) {
           throw new BusinessRuleException("Your balance is insufficient!", ErrorCode.YOUR_BALANCE_IS_INSUFFICIENT);
       }
    }
}
