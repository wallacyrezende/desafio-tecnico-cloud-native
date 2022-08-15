package br.com.bluebank.model.exceptions;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class AccountHolderNotFoundException extends Exception implements Serializable {

    private static final long serialVersionUID = 4732146747382992124L;
    private final int code;
    public AccountHolderNotFoundException(String message, int code) {
        super(message);
        this.code = code;
    }
}
