package com.example.api.controllers.controlletexceptions;

import com.example.infrastructure.exceptions.UserAlreadyExitsException;
import com.example.infrastructure.exceptions.UserFieldNotValidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptions extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptions.class);

    @ExceptionHandler(UserFieldNotValidException.class)
    public void UserFieldNotValidException(UserFieldNotValidException userFieldNotValidException, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, userFieldNotValidException.getMessage());
    }

    @ExceptionHandler(UserAlreadyExitsException.class)
    public void UserAlreadyExitsException(UserAlreadyExitsException userAlreadyExitsException, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, userAlreadyExitsException.getMessage());
    }
}
