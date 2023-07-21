package com.example.newprojectworkshop.exception;

import com.example.newprojectworkshop.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
public class UserExceptionHandler {


        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
            List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
            List<String>errMsg=errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
            ResponseDTO respdto=new ResponseDTO("exception while processing RESTAPI",errMsg);
            return new ResponseEntity<>(respdto, HttpStatus.BAD_REQUEST);
        }
        @ExceptionHandler(UserCustomException.class)
        public ResponseEntity<ResponseDTO>handleEmpCustomException(UserCustomException exception){
            ResponseDTO respdto=new ResponseDTO("Exception while processing RESTAPI",exception.getMessage());
            return  new ResponseEntity<>(respdto,HttpStatus.BAD_REQUEST);
        }


    }

