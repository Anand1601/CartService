package com.cartService.Services.Impl;

import com.cartService.Entities.Cart;
import com.cartService.Entities.Item;
import com.cartService.Exceptions.CartNotFoundException;
import com.cartService.Exceptions.ItemNotFoundException;
import com.cartService.Services.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
        public Item addItemCart(Item item, int cartId) throws CartNotFoundException {
          return null;
        }
    public Cart getCartOfItem(int itemId) throws ItemNotFoundException {

            return null;
    }
    public List<Item> getItemsFromTheCart(int cartId) throws CartNotFoundException{
            return null;
    }
}
