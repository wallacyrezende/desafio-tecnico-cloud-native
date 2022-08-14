package br.com.bluebank.service.accountHolder;

import br.com.bluebank.model.dto.accountholder.CreateAccountHolderDTO;
import br.com.bluebank.model.dto.accountholder.ResponseAccountHolderDTO;
import br.com.bluebank.model.entities.AccountHolder;
import org.springframework.stereotype.Service;

@Service
public class AccountHolderServiceImpl implements AccountHolderService {

    @Override
    public void createAccountHolder(CreateAccountHolderDTO dto) {
        //TODO createAccountHolder method
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
}
