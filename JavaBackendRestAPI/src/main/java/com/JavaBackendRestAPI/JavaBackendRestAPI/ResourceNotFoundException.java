package com.JavaBackendRestAPI.JavaBackendRestAPI;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
