package com.technep.ramjanaki.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created by surajgautam on 7/2/17.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView returnHandlerException(){

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("errorTitle","Page Not Found");
        modelAndView.addObject("errorDescription","The page you are looking for is not constructed yet. Please contact your administrator");
        modelAndView.addObject("title","404 Error");
        modelAndView.addObject("userErrorStatus",true);
        return modelAndView;

    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView returnProductException(Exception ex){

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("errorTitle","Product Not found");
        modelAndView.addObject("errorDescription",ex.getMessage());
        modelAndView.addObject("title","Error");
        modelAndView.addObject("userErrorStatus",true);
        return modelAndView;

    }

    //when some one submits string in cat/product id
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView returnNumberFormatException(Exception ex){

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("errorTitle","Illegal Request");
        modelAndView.addObject("errorDescription","Please enter related numbers not string");
        modelAndView.addObject("title","Error");
        modelAndView.addObject("userErrorStatus",true);
        return modelAndView;

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView dataIntegrityViolation(Exception ex){

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("errorTitle","Caught you");
        modelAndView.addObject("errorDescription","Might be duplicate entry, have a look");
        modelAndView.addObject("title","Error");
        modelAndView.addObject("userErrorStatus",true);
        return modelAndView;

    }
}
