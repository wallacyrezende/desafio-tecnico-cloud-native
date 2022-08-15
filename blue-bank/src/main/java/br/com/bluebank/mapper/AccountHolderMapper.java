package br.com.bluebank.mapper;

import br.com.bluebank.model.dto.accountholder.CreateAccountHolderDTO;
import br.com.bluebank.model.dto.accountholder.AccountHolderDTO;
import br.com.bluebank.model.entities.AccountHolder;
import br.com.bluebank.model.exceptions.NullOrEmptyObjectException;
import br.com.bluebank.model.exceptions.utils.NullOrEmptyFieldException;
import org.springframework.stereotype.Component;

@Component
public class AccountHolderMapper extends Mapper {

    public static AccountHolder buildAccountHolder(CreateAccountHolderDTO dto) {
        if(isNull(dto)) {
            throw new NullOrEmptyObjectException(CreateAccountHolderDTO.class.getSimpleName());
        }

        return AccountHolder.builder()
                .branch(dto.getBranch())
                .account(dto.getAccount())
                .cpf(dto.getCpf())
                .balance(dto.getBalance())
                .build();
    }

    public static AccountHolder buildAccountHolder(AccountHolderDTO dto, Long accountHolderId) {
        if(isNull(dto)) {
            throw new NullOrEmptyObjectException(AccountHolderDTO.class.getSimpleName());
        }

        if(isNull(accountHolderId)) {
            throw new NullOrEmptyFieldException("accountHolderId");
        }

        return AccountHolder.builder()
                .id(accountHolderId)
                .branch(dto.getBranch())
                .account(dto.getAccount())
                .cpf(dto.getCpf())
                .balance(dto.getBalance())
                .build();
    }

    public static AccountHolderDTO buildAccountHolderDTO(AccountHolder accountHolder) {
        if(isNull(accountHolder)) {
            throw new NullOrEmptyObjectException(AccountHolder.class.getSimpleName());
        }

        return AccountHolderDTO.builder()
                .branch(accountHolder.getBranch())
                .account(accountHolder.getAccount())
                .cpf(accountHolder.getCpf())
                .balance(accountHolder.getBalance())
                .build();
    }

}
