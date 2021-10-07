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

		Item item = new Item();
		item.setMfgDate(LocalDateTime.of(2020,1,12,5,0));
System.out.println("hello spring");

	}

}
