package com.cartService.Controllers;

import com.cartService.DTOs.CartDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*
* 127.0.0.1.8080/cartService/v1/carts
* */
@RequestMapping("/carts")
public class CartController {

    @GetMapping
    public ResponseEntity helloStudent()
    {
        return new ResponseEntity("Hello Students", HttpStatus.OK);
    }
    /*
    * create an endpoint to create the cart
    *
    * POST 127.0.0.1:8080/cartService/v1/carts
    * */
    public ResponseEntity createCart(CartDTO cartDTO)
    {
        return null;
    }


}
