package com.cartService;

import com.cartService.Entities.Item;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class CartServiceApplication {

	public static void main(String[] args) {


ApplicationContext applicationContext = SpringApplication.run(CartServiceApplication.class,args);



	}

}
