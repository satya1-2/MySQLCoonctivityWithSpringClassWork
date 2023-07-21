package com.example.newprojectworkshop.exception;

import org.apache.logging.log4j.message.StringFormattedMessage;

public class UserCustomException extends RuntimeException{
    public UserCustomException(String message){

  super(message);

    }
}
