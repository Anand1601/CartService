package com.cartService.exceptionHandlers;

import com.cartService.Exceptions.CartNotFoundException;
import com.cartService.Exceptions.CustomerNameNotFoundException;
import com.cartService.Exceptions.ItemNotFoundException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class controllerExceptionHandler {

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity handlerCartNotFoundException(){
return new ResponseEntity("Cart Id passed is invalid/not found", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNameNotFoundException.class)
    public ResponseEntity handleCustomerNameNotFoundException(){
        return new ResponseEntity("No customer found/invalid customer",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity handleItemNotFoundException(){
        return new ResponseEntity("No item found/invalid item",HttpStatus.BAD_REQUEST);
    }


}
