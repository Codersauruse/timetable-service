package com.astraride.timetableservice.util.exceptions;

public class DataAlreadyExistsException extends RuntimeException{
    public  DataAlreadyExistsException(String message){
        super(message);
    }
}
