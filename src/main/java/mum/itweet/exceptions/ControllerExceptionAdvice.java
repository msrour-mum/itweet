package mum.itweet.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class ControllerExceptionAdvice {

//    @ExceptionHandler
//    public String handelException(Exception ex)
//    {
//        System.out.println("Error while execution, [ERROR]: " + ex);
//        return "redirect:/error";
//    }
}
