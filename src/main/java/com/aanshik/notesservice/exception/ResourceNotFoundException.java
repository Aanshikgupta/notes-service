package com.aanshik.notesservice.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Long id,String resourceName){
        super(resourceName+" with id = "+id+" not found");
    }
}
