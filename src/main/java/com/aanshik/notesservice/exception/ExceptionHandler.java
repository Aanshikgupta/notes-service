package com.aanshik.notesservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", resourceNotFoundException.getLocalizedMessage());
        errorMap.put("status", "FAILED");
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }


//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException exception,
//            HttpHeaders httpHeaders, HttpStatus httpStatus,
//            WebRequest webRequest){
//
//        Map<String, Object> objectBody = new LinkedHashMap<>();
//        objectBody.put("Current Timestamp", new Date());
//        objectBody.put("Status", httpStatus.value());
//
//        // Get all errors
//        List<String> exceptionalErrors
//                = exception.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(x -> x.getDefaultMessage())
//                .collect(Collectors.toList());
//
//        objectBody.put("Errors", exceptionalErrors);
//
//        return new ResponseEntity<>(objectBody, httpStatus);
//    }


}
