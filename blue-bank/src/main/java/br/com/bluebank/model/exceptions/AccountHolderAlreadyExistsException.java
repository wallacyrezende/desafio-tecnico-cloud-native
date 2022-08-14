package br.com.bluebank.model.exceptions;

import java.io.Serializable;

public class AccountHolderAlreadyExistsException  extends Exception implements Serializable {

    private static final long serialVersionUID = -8655085198805750557L;
    private static final String MESSAGE = "Account holder already exists";
    private final int code;
    public AccountHolderAlreadyExistsException(int code) {
        super(MESSAGE);
        this.code = code;
    }
}
