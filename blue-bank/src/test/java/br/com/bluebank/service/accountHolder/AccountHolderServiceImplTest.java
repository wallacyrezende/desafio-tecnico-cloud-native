package br.com.bluebank.service.accountHolder;

import br.com.bluebank.model.dto.accountholder.AccountHolderDTO;
import br.com.bluebank.model.dto.accountholder.CreateAccountHolderDTO;
import br.com.bluebank.model.entities.AccountHolder;
import br.com.bluebank.model.enums.TransactionType;
import br.com.bluebank.model.exceptions.AccountHolderAlreadyExistsException;
import br.com.bluebank.model.exceptions.AccountHolderNotFoundException;
import br.com.bluebank.repository.accountholder.AccountHolderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@DisplayName("Account holder service tests")
@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class AccountHolderServiceImplTest {

    AccountHolderRepository accountHolderRepository;
    AccountHolderService accountHolderService;

    static final Long ACCOUNT =  5332l;
    static final String BRANCH = "000-1";
    static final String CPF = "123.123.123-12";
    static final Double BALANCE = 100d;

    @BeforeEach
    void setup() {
        accountHolderRepository = Mockito.mock(AccountHolderRepository.class);
        accountHolderService = new AccountHolderServiceImpl(accountHolderRepository);
    }

    @Test
    @DisplayName("MUST create new account holder")
    void mustCreateAccountHolder() throws AccountHolderAlreadyExistsException {
        Mockito.when(accountHolderRepository.findByCpf(Mockito.anyString())).thenReturn(Optional.empty());

        CreateAccountHolderDTO dto = CreateAccountHolderDTO.builder()
                .account(ACCOUNT)
                .branch(BRANCH)
                .cpf(CPF)
                .build();

        AccountHolder accountHolderSaved = buildAccountHolder();

        Mockito.when(accountHolderRepository.save(Mockito.any(AccountHolder.class))).thenReturn(accountHolderSaved);

        accountHolderService.saveAccountHolder(dto);

        Mockito.verify(accountHolderRepository, Mockito.times(1)).save(accountHolderSaved);

    }

    @Test
    @DisplayName("MUST find a account holder by id")
    void mustFindAccountHolder() throws AccountHolderNotFoundException {

        Long id = 1L;
        AccountHolder accountHolder = buildAccountHolder();
        accountHolder.setId(id);

        Mockito.when(accountHolderRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(accountHolder));

        AccountHolderDTO accountHolderFound = accountHolderService.findAccountHolder(id);

        Assertions.assertNotNull(accountHolderFound);
        Assertions.assertEquals(CPF, accountHolderFound.getCpf());

    }

    @Test
    @DisplayName("MUST update a account holder by AccountHolderDTO and accountHolderId")
    void mustUpdateAccountHolder() {

        Long accountHolderId = 1L;
        AccountHolder accountHolder = buildAccountHolder();
        accountHolder.setId(accountHolderId);
        accountHolder.setBalance(50d);

        AccountHolderDTO accountHolderDTO = buildAccountHolderDTO();
        accountHolderDTO.setBalance(50d);

        Mockito.when(accountHolderRepository.save(Mockito.any(AccountHolder.class))).thenReturn(accountHolder);

        accountHolderService.updateAccountHolder(accountHolderDTO, accountHolderId);

        Mockito.verify(accountHolderRepository).save(accountHolder);
        Assertions.assertEquals(50D, accountHolderDTO.getBalance());

    }

    @Test
    @DisplayName("MUST make a bank transaction ")
    void mustMakeABankTransaction() throws AccountHolderNotFoundException {

        Long accountHolderId = 1L;
        Double amount = 10d;
        TransactionType transactionType = TransactionType.CREDIT;

        AccountHolder accountHolderFound = buildAccountHolder();
        accountHolderFound.setId(accountHolderId);
        accountHolderFound.setBalance(amount);

        AccountHolder accountHolderToSave = buildAccountHolder();
        accountHolderToSave.setId(accountHolderId);
        accountHolderToSave.setBalance(amount);

        Mockito.when(accountHolderRepository.findById(Mockito.any())).thenReturn(Optional.of(accountHolderFound));
        Mockito.when(accountHolderRepository.save(Mockito.any(AccountHolder.class))).thenReturn(accountHolderToSave);

       /** TODO validade bank transaction **/
    }

    private AccountHolder buildAccountHolder() {
        return AccountHolder.builder()
                .account(ACCOUNT)
                .branch(BRANCH)
                .cpf(CPF)
                .build();
    }

    private AccountHolderDTO buildAccountHolderDTO() {
        return AccountHolderDTO.builder()
                .account(ACCOUNT)
                .cpf(CPF)
                .branch(BRANCH)
                .balance(BALANCE)
                .build();
    }
}