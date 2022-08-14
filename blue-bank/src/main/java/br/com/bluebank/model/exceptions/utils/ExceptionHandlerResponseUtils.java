package br.com.bluebank.model.exceptions.utils;

import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

public class ExceptionHandlerResponseUtils {

    public static ExceptionResponse buildExceptionResponse(Exception ex, WebRequest request){
        return ExceptionResponse.builder().dateTime(LocalDateTime.now())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .build();
    }
}
