package br.com.bluebank.mapper;

import br.com.bluebank.model.entities.AccountHolder;
import br.com.bluebank.model.dto.accountholder.CreateAccountHolderDTO;
import br.com.bluebank.model.exceptions.NullOrEmptyObjectException;
import br.com.bluebank.service.accountHolder.AccountHolderService;
import org.springframework.stereotype.Component;

@Component
public class AccountHolderMapper extends Mapper {

    private final AccountHolderService accountHolderService;

    public AccountHolderMapper(AccountHolderService accountHolderService) {
        this.accountHolderService = accountHolderService;
    }

    public AccountHolder buildAddress(CreateAccountHolderDTO dto) {
        if(isNull(dto)) {
            throw new NullOrEmptyObjectException(CreateAccountHolderDTO.class.getSimpleName());
        }

        return AccountHolder.builder()
                .branch(dto.getBranch())
                .account(dto.getAccount())
                .CPF(dto.getCPF())
                .build();
    }

    public CreateAccountHolderDTO buildAddress(AccountHolder accountHolder) {
        if(isNull(accountHolder)) {
            throw new NullOrEmptyObjectException(CreateAccountHolderDTO.class.getSimpleName());
        }

        return CreateAccountHolderDTO.builder()
                .branch(accountHolder.getBranch())
                .account(accountHolder.getAccount())
                .CPF(accountHolder.getCPF())
                .build();
    }

}
