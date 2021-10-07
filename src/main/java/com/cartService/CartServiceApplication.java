package com.cartService;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class CartServiceApplication {

	public static void main(String[] args) {


ApplicationContext applicationContext = SpringApplication.run(CartServiceApplication.class,args);

System.out.println("hello spring");

	}

}
