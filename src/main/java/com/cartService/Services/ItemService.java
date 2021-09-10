package com.cartService.Services;

import com.cartService.Entities.Cart;
import com.cartService.Entities.Item;
import com.cartService.Exceptions.CartNotFoundException;
import com.cartService.Exceptions.ItemNotFoundException;

import java.util.List;

public interface ItemService {
      public Item addItemCart(Item item, int cartId) throws CartNotFoundException;
    public Cart getCartOfItem(int itemId) throws ItemNotFoundException;
    public List<Item> getItemsFromTheCart(int cartId) throws CartNotFoundException;
}
