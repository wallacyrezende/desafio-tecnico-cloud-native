package br.com.bluebank.service.accountHolder;

import br.com.bluebank.mapper.AccountHolderMapper;
import br.com.bluebank.mapper.TransactionMapper;
import br.com.bluebank.model.dto.accountholder.AccountHolderDTO;
import br.com.bluebank.model.dto.accountholder.CreateAccountHolderDTO;
import br.com.bluebank.model.dto.bankTransfer.TransactionDTO;
import br.com.bluebank.model.entities.AccountHolder;
import br.com.bluebank.model.enums.ErrorCode;
import br.com.bluebank.model.enums.TransactionType;
import br.com.bluebank.model.exceptions.AccountHolderAlreadyExistsException;
import br.com.bluebank.model.exceptions.AccountHolderNotFoundException;
import br.com.bluebank.repository.accountholder.AccountHolderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountHolderServiceImpl implements AccountHolderService {

    private final AccountHolderRepository accountHolderRepository;

    public AccountHolderServiceImpl(AccountHolderRepository accountHolderRepository) {
        this.accountHolderRepository = accountHolderRepository;
    }

    @Override
    public void saveAccountHolder(CreateAccountHolderDTO dto) throws AccountHolderAlreadyExistsException {
        validate(dto);
        AccountHolder accountHolder = AccountHolderMapper.buildAccountHolder(dto);
        accountHolderRepository.save(accountHolder);
    }

    @Override
    public AccountHolderDTO findAccountHolder(Long id) throws AccountHolderNotFoundException {
        Optional<AccountHolder> accountHolder = accountHolderRepository.findById(id);
        if(accountHolder.isEmpty()) {
            throw new AccountHolderNotFoundException("Account holder not found!", ErrorCode.ACCOUNT_HOLDER_NOT_FOUND);
        }
       return AccountHolderMapper.buildAccountHolderDTO(accountHolder.get());
    }

    @Override
    public AccountHolderDTO updateAccountHolder(AccountHolderDTO dto, Long accountHolderId) {
        AccountHolder entity = accountHolderRepository.save(AccountHolderMapper.buildAccountHolder(dto, accountHolderId));
        return AccountHolderMapper.buildAccountHolderDTO(entity);
    }

    @Override
    public TransactionDTO bankTransaction(Long accountHolderId, Double amount, TransactionType type) throws AccountHolderNotFoundException {
        AccountHolderDTO accountHolderDTO = findAccountHolder(accountHolderId);
        AccountHolder accountHolderToSave = AccountHolderMapper.buildAccountHolder(accountHolderDTO, accountHolderId);
        updateBalance(accountHolderToSave, type, amount);
        AccountHolder accountHolderEntity = accountHolderRepository.save(accountHolderToSave);
        return TransactionMapper.buildTransactionDTO(accountHolderEntity, type, amount);
    }

    private void validate(CreateAccountHolderDTO dto) throws AccountHolderAlreadyExistsException {
        validateExistAccountHolder(dto.getCpf());
    }
    private void validateExistAccountHolder(String cpf) throws AccountHolderAlreadyExistsException {
        if(accountHolderRepository.findByCpf(cpf).isPresent())
            throw new AccountHolderAlreadyExistsException(ErrorCode.ACCOUNT_HOLDER_ALREADY_EXISTS_EXCEPTION);
    }

    private void updateBalance(AccountHolder accountHolder, TransactionType type, Double amount) {

        switch (type) {
            case CREDIT:
                accountHolder.creditAmout(amount);
                break;
            case DEBIT:
                accountHolder.debitAmout(amount);
                break;
        }

    }
}
