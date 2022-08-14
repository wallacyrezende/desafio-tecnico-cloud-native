package br.com.bluebank.service.accountHolder;

import br.com.bluebank.model.dto.accountholder.CreateAccountHolderDTO;
import br.com.bluebank.model.dto.accountholder.ResponseAccountHolderDTO;
import br.com.bluebank.model.entities.AccountHolder;

public interface AccountHolderService {

    void createAccountHolder(CreateAccountHolderDTO dto);

    AccountHolder findAccountHolder(Integer id);

    ResponseAccountHolderDTO updateAccountHolder(CreateAccountHolderDTO dto, Integer id);
}
