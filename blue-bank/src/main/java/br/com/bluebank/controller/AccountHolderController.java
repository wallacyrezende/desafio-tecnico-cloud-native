package br.com.bluebank.controller;

import br.com.bluebank.model.dto.accountholder.CreateAccountHolderDTO;
import br.com.bluebank.model.dto.accountholder.ResponseAccountHolderDTO;
import br.com.bluebank.service.accountHolder.AccountHolderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/account-holder")
public class AccountHolderController {

    private final AccountHolderService accountHolderService;

    public AccountHolderController(AccountHolderService accountHolderService) {
        this.accountHolderService = accountHolderService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody CreateAccountHolderDTO dto) {
        accountHolderService.createAccountHolder(dto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void find(@PathVariable Integer id) {
        accountHolderService.findAccountHolder(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseAccountHolderDTO update(@Valid @RequestBody CreateAccountHolderDTO dto, @PathVariable Integer id) {
        return accountHolderService.updateAccountHolder(dto, id);
    }
}
