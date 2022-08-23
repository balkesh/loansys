package com.thoughtprocess.loansys.controlAdvice;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


import java.util.HashMap;
import java.util.Map;



@ControllerAdvice
public class ControlExc {

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<Object> ilAccessExc(IllegalAccessException ex, WebRequest web){
        Map<String,String> m = new HashMap<>();
        m.put("status", HttpStatus.OK.toString());
        m.put( "desc", ex.getMessage());
        return new ResponseEntity<>(m,
                HttpStatus.OK);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> ilAccessExc(Exception ex, WebRequest web){
        Map<String,String> m = new HashMap<>();
        m.put("status", HttpStatus.OK.toString());
        m.put("desc", ex.getMessage());
        return new ResponseEntity<>(m,
                HttpStatus.OK);

    }

}
