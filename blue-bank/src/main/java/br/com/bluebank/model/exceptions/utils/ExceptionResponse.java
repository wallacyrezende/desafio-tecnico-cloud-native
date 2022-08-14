package br.com.bluebank.model.exceptions.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 2635470730736610691L;

    private LocalDateTime dateTime;
    private String message;
    private String details;
    private int code;
}