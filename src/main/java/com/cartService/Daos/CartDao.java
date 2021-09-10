package com.cartService.Daos;

import com.cartService.Entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<Cart,Integer> {
public Cart findByCustomerName(String userName);
}
