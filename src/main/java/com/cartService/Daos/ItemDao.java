package com.cartService.Daos;

import com.cartService.Entities.Cart;
import com.cartService.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemDao extends JpaRepository<Item, Integer> {

    public List<Item> findItemsByCart(Cart cart);
    public List<Item> findByItemName(String itemName);
}
