package com.astraride.timetableservice.util.exceptions;

import com.astraride.timetableservice.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<StandardResponse> handleNoDataFoundException(NoDataFoundException ex) {
        StandardResponse response = new StandardResponse(404, ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidArgumentExeception.class)
    public ResponseEntity<StandardResponse> handleInvalidArgumentError(InvalidArgumentExeception ex) {
        StandardResponse response = new StandardResponse(400, ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(DataAlreadyExistsException.class)
    public ResponseEntity<StandardResponse> handleDataAlreadyExistsException(DataAlreadyExistsException ex) {
        StandardResponse response = new StandardResponse(409, ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardResponse> handleGenericError(Exception ex) {
        StandardResponse response = new StandardResponse(500, "Unexpected error occurred", null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}