package br.com.bluebank.controller;

import br.com.bluebank.model.dto.accountholder.CreateAccountHolderDTO;
import br.com.bluebank.model.dto.accountholder.AccountHolderDTO;
import br.com.bluebank.model.exceptions.AccountHolderAlreadyExistsException;
import br.com.bluebank.model.exceptions.AccountHolderNotFoundException;
import br.com.bluebank.service.accountHolder.AccountHolderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Account holder Controller")
@RestController
@RequestMapping("/account-holder")
public class AccountHolderController {

    private final AccountHolderService accountHolderService;

    public AccountHolderController(AccountHolderService accountHolderService) {
        this.accountHolderService = accountHolderService;
    }

    @Operation(summary = "Create new Account holder")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody CreateAccountHolderDTO dto) throws AccountHolderAlreadyExistsException {
        accountHolderService.saveAccountHolder(dto);
    }

    @Operation(summary = "Find user by id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountHolderDTO find(@PathVariable Long id) throws AccountHolderNotFoundException {
        return accountHolderService.findAccountHolder(id);
    }

    @Operation(summary = "Update account holder by id")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountHolderDTO update(@Valid @RequestBody AccountHolderDTO dto, @PathVariable Long id) {
        return accountHolderService.updateAccountHolder(dto, id);
    }
}
