package br.com.bluebank.service.accountHolder;

import br.com.bluebank.mapper.AccountHolderMapper;
import br.com.bluebank.model.dto.accountholder.CreateAccountHolderDTO;
import br.com.bluebank.model.dto.accountholder.ResponseAccountHolderDTO;
import br.com.bluebank.model.entities.AccountHolder;
import br.com.bluebank.model.enums.ErrorCode;
import br.com.bluebank.model.exceptions.AccountHolderAlreadyExistsException;
import br.com.bluebank.model.exceptions.BusinessRuleException;
import br.com.bluebank.repository.accountholder.AccountHolderRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountHolderServiceImpl implements AccountHolderService {

    private final AccountHolderRepository accountHolderRepository;

    public AccountHolderServiceImpl(AccountHolderRepository accountHolderRepository) {
        this.accountHolderRepository = accountHolderRepository;
    }

    @Override
    public void createAccountHolder(CreateAccountHolderDTO dto) throws AccountHolderAlreadyExistsException {
        validate(dto);
        AccountHolder accountHolder = AccountHolderMapper.buildAddress(dto);
        accountHolderRepository.save(accountHolder);
    }

    @Override
    public AccountHolder findAccountHolder(Integer id) {
       // TODO findAccountHolder method
        return null;
    }

    @Override
    public ResponseAccountHolderDTO updateAccountHolder(CreateAccountHolderDTO dto, Integer id) {
        //TODO updateAccountHolder method
        return null;
    }

    private void validate(CreateAccountHolderDTO dto) throws AccountHolderAlreadyExistsException, BusinessRuleException {
        validateExistAccountHolder(dto);
    }
    private void validateExistAccountHolder(CreateAccountHolderDTO dto) throws AccountHolderAlreadyExistsException {
        if(accountHolderRepository.findByCPF(dto.getCPF()).isPresent())
            throw new AccountHolderAlreadyExistsException(ErrorCode.ACCOUNT_HOLDER_ALREADY_EXISTS_EXCEPTION);
    }
}
