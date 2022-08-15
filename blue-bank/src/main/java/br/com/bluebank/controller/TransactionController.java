package br.com.bluebank.controller;

import br.com.bluebank.model.dto.bankTransfer.BankTransactionDTO;
import br.com.bluebank.model.exceptions.AccountHolderNotFoundException;
import br.com.bluebank.model.exceptions.BusinessRuleException;
import br.com.bluebank.service.transaction.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "Transactions Controller")
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Operation(summary = "Bank transfer between account holders")
    @PatchMapping("/transfer")
    @ResponseStatus(HttpStatus.OK)
    public void transfer(@Valid @RequestBody BankTransactionDTO dto) throws AccountHolderNotFoundException, BusinessRuleException {
        transactionService.transfer(dto);
    }

    @Operation(summary = "Add credit to the account holders")
    @PatchMapping("/credit")
    @ResponseStatus(HttpStatus.OK)
    public void credit(@RequestParam("accountHolderId") Long accountHolderId,
                       @RequestParam("amount") Double amount) throws AccountHolderNotFoundException {
        transactionService.creditAmount(accountHolderId, amount);
    }
}
