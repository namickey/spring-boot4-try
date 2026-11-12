package com.example.demo.core.exception;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.common.messege.MessageConst;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class WebExceptionHandler {

    private final MessageSource messages;
    private static final Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

    @ExceptionHandler(AppException.class)
    public String handleAppException(AppException e, HttpServletResponse response, Model model) {
        int status = MessageConst.ME404.equals(e.getMessageId())
                ? HttpStatus.NOT_FOUND.value()
                : HttpStatus.BAD_REQUEST.value();
        response.setStatus(status);
        model.addAttribute("message", messages.getMessage(e.getMessageId(), null, Locale.getDefault()));
        return "error";
    }

    @ExceptionHandler(SystemException.class)
    public String handleSystemException(SystemException t, HttpServletResponse response) {
        logger.error(messages.getMessage(t.getMessageId(), null, Locale.getDefault()), t);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception t, HttpServletResponse response) {
        logger.error(t.getMessage(), t);
        int status = t instanceof ErrorResponse errorResponse
                ? errorResponse.getStatusCode().value()
                : HttpStatus.INTERNAL_SERVER_ERROR.value();
        response.setStatus(status);
        return "error";
    }
}
