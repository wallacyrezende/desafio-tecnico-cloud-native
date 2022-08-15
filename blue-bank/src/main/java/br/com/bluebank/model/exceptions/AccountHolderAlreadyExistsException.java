package br.com.bluebank.model.exceptions;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class AccountHolderAlreadyExistsException  extends Exception implements Serializable {

    private static final long serialVersionUID = -8655085198805750557L;
    private static final String MESSAGE = "Account holder already exists, please enter another CPF";
    private final int code;
    public AccountHolderAlreadyExistsException(int code) {
        super(MESSAGE);
        this.code = code;
    }
}
