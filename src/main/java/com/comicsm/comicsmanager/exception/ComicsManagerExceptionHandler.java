package com.comicsm.comicsmanager.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ComicsManagerExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String CONSTANT_VALIDATION_NOT_BLANK = "NotBlank";
    public static final String CONSTANT_VALIDATION_LENGTH = "Length";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Error> errors = generateErrorList(ex.getBindingResult());

        return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
    }

    private List<Error> generateErrorList(BindingResult bindingResult) {
        List<Error> errors = new ArrayList<Error>();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            String msgUser = handleErrorMessageForUser(fieldError);
            String msgDeveloper = fieldError.toString();
            errors.add(new Error(msgUser, msgDeveloper));
        });
        return errors;
    }

    private String handleErrorMessageForUser(FieldError fieldError) {
        if (fieldError.getCode().equals(CONSTANT_VALIDATION_NOT_BLANK)) {
            return fieldError.getDefaultMessage().concat(" is required");
        }
        if (fieldError.getCode().equals(CONSTANT_VALIDATION_LENGTH)){
            return fieldError.getDefaultMessage().concat(String.format(" must have between %s and %s characters.", fieldError.getArguments()[2], fieldError.getArguments()[1]));
        }
        return fieldError.toString();
    }
}
