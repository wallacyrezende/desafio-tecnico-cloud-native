package br.com.bluebank.model.exceptions.handler;

import br.com.bluebank.model.exceptions.AccountHolderAlreadyExistsException;
import br.com.bluebank.model.exceptions.AccountHolderNotFoundException;
import br.com.bluebank.model.exceptions.BusinessRuleException;
import br.com.bluebank.model.exceptions.NullOrEmptyObjectException;
import br.com.bluebank.model.exceptions.utils.ExceptionHandlerResponseUtils;
import br.com.bluebank.model.exceptions.utils.ExceptionResponse;
import br.com.bluebank.model.exceptions.utils.NullOrEmptyFieldException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ControllerAdvisor.class);

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleExceptions(Exception ex, WebRequest request){
        ex.printStackTrace();
        return new ResponseEntity(ExceptionHandlerResponseUtils.buildGenericExceptionResponse(request), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessRuleException.class)
    public final ResponseEntity<?> handleBusinessRuleException(BusinessRuleException ex, WebRequest request){
        ex.printStackTrace();
        ExceptionResponse exceptionResponse = ExceptionHandlerResponseUtils.buildExceptionResponse(ex, request);
        exceptionResponse.setCode(ex.getCode());
        logger.error(exceptionResponse.toString());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullOrEmptyObjectException.class)
    public final ResponseEntity<?> handleNullOrEmptyObjectException(NullOrEmptyObjectException ex, WebRequest request) {
        ex.printStackTrace();
        ExceptionResponse exceptionResponse = ExceptionHandlerResponseUtils.buildExceptionResponse(ex, request);
        exceptionResponse.setCode(ex.getCode());
        logger.error(exceptionResponse.toString());
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(AccountHolderAlreadyExistsException.class)
    public final ResponseEntity<?> handleAccountHolderAlreadyExistsException(AccountHolderAlreadyExistsException ex, WebRequest request) {
        ex.printStackTrace();
        ExceptionResponse exceptionResponse = ExceptionHandlerResponseUtils.buildExceptionResponse(ex, request);
        exceptionResponse.setCode(ex.getCode());
        logger.error(exceptionResponse.toString());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccountHolderNotFoundException.class)
    public final ResponseEntity<?> handleAccountHolderNotFoundException(AccountHolderNotFoundException ex, WebRequest request) {
        ex.printStackTrace();
        ExceptionResponse exceptionResponse = ExceptionHandlerResponseUtils.buildExceptionResponse(ex, request);
        exceptionResponse.setCode(ex.getCode());
        logger.error(exceptionResponse.toString());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullOrEmptyFieldException.class)
    public final ResponseEntity<?> handleNullOrEmptyFieldException(NullOrEmptyFieldException ex, WebRequest request) {
        ex.printStackTrace();
        ExceptionResponse exceptionResponse = ExceptionHandlerResponseUtils.buildExceptionResponse(ex, request);
        exceptionResponse.setCode(ex.getCode());
        logger.error(exceptionResponse.toString());
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
