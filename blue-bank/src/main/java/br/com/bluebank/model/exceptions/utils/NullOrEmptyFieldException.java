package br.com.bluebank.model.exceptions.utils;

import br.com.bluebank.model.enums.ErrorCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class NullOrEmptyFieldException extends RuntimeException implements Serializable {


    private static final long serialVersionUID = -3103282829637637669L;
    private static final String MESSAGE = "The field can't be null or empty: %s";
    private final int code;

    public NullOrEmptyFieldException(String field) {
        super(String.format(MESSAGE, field));
        this.code = ErrorCode.FIELD_CAN_NOT_BE_NULL_OR_EMPTY;
    }
}
