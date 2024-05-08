package net.nvsoftware.springmono.error;

import net.nvsoftware.springmono.model.ErrorMsg;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class RestAPI_ResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public ErrorMsg ProductNotFoundHandler (ProductNotFoundException e) {
        ErrorMsg errorMsg = new ErrorMsg(HttpStatus.NOT_FOUND, e.getMessage());
        return errorMsg;
    }

}
