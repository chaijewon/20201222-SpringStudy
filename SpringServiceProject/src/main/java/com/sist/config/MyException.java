package com.sist.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class MyException {
   @ExceptionHandler(NoHandlerFoundException.class)
   public String error(NoHandlerFoundException ex,Model model)
   {
	   model.addAttribute("exception", ex.getMessage());
	   return "error/error_page";
   }
}
