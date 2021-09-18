package com.cartService;

import com.cartService.Daos.CartDao;
import com.cartService.Daos.ItemDao;
import com.cartService.Entities.Cart;
import com.cartService.Entities.Item;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class CartServiceApplication {

	public static void main(String[] args) {


ApplicationContext applicationContext = SpringApplication.run(CartServiceApplication.class,args);
/*
CartDao cartDao = applicationContext.getBean(CartDao.class);
		ItemDao itemDao = applicationContext.getBean(ItemDao.class);

		System.out.println("cart :"+cartDao);
		System.out.println("item :"+itemDao);
		System.out.println("Hello spring");

		*/
/*
		* create cart
		* *//*


		Cart cart = new Cart();
		cart.setCustomerName("vivek mohan");
		cartDao.save(cart);

		*/
/*
		* Items
		* *//*


		Item item = new Item();
		item.setItemName("detergent powder");
		item.setCategory("Households");
		item.setItemDescription("Grate product ");
		item.setCost(500);
		item.setMfgDate(LocalDateTime.of(2021,7,12,10,2));
		item.setCart(cart);
		itemDao.save(item);
*/

	}

}
