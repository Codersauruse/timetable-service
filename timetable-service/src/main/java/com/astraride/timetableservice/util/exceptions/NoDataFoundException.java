package com.astraride.timetableservice.util.exceptions;

public class NoDataFoundException extends  RuntimeException{
    public NoDataFoundException (String message){
        super(message);
    }
}