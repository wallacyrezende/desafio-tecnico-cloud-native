package br.com.bluebank.model.exceptions;

import br.com.bluebank.model.enums.ErrorCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class NullOrEmptyObjectException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -3103282829637637669L;
    private static final String MESSAGE = "The object can't be null or empty: %s";
    private final int code;
    public NullOrEmptyObjectException(String object) {
        super(String.format(MESSAGE, object));
        this.code = ErrorCode.OBJECT_CAN_NOT_BE_NULL_OR_EMPTY;
    }
}
