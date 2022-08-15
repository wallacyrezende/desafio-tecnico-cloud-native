package br.com.bluebank.model.exceptions;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class BusinessRuleException extends Exception implements Serializable {

    private static final long serialVersionUID = -3103282829637637669L;
    private final int code;
    public BusinessRuleException(String message, int code) {
        super(message);
        this.code = code;
    }
}
