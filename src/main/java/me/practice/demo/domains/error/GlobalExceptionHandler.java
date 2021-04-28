package me.practice.demo.domains.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public @ResponseBody String illegalStateException() {
        return "이미 존재하는 이멜 ㅠㅠ";
    }

}
