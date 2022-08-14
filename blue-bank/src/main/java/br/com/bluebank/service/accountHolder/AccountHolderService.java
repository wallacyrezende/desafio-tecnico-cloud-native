package br.com.bluebank.service.accountHolder;

import br.com.bluebank.model.dto.accountholder.CreateAccountHolderDTO;
import br.com.bluebank.model.dto.accountholder.ResponseAccountHolderDTO;
import br.com.bluebank.model.entities.AccountHolder;
import br.com.bluebank.model.exceptions.AccountHolderAlreadyExistsException;

public interface AccountHolderService {

    void createAccountHolder(CreateAccountHolderDTO dto) throws AccountHolderAlreadyExistsException;

    AccountHolder findAccountHolder(Integer id);

    ResponseAccountHolderDTO updateAccountHolder(CreateAccountHolderDTO dto, Integer id);
}
