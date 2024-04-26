package com.cloudbees.controller;

import java.net.http.HttpRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cloudbees.service.exception.TicketNotFoundException;

@ControllerAdvice
public class GlobalExceptionController 
extends ResponseEntityExceptionHandler {

  @ExceptionHandler({ TicketNotFoundException.class })
  public ResponseEntity<Object> handleAccessDeniedException(
    Exception ex, WebRequest request) {
      return new ResponseEntity<Object>(
        "Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
  }
  
  
}