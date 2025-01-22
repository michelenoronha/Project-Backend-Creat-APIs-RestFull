package com.test;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class RestExceptionhandler {

    @ExceptionHandler(ResourceNotFoundException) 
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex)[
       
    ErrorMessage error = new ErrorMessage("not Found", HttpStatus.Not_found.value(),
     404, ex.getMessage());
return new ResponseEntity<>(error,httpStatus.NOT_found);
}
