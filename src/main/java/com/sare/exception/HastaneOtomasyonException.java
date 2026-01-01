package com.sare.exception;

import lombok.Getter;

@Getter
public class HastaneOtomasyonException extends RuntimeException{
    private ErrorType errorType;

    public HastaneOtomasyonException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
