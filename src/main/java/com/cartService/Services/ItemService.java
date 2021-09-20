package com.cartService.Services;

import com.cartService.Entities.Cart;
import com.cartService.Entities.Item;
import com.cartService.Exceptions.CartNotFoundException;
import com.cartService.Exceptions.ItemNotFoundException;

import java.util.List;

public interface ItemService {
      public Item createItem(Item item) throws CartNotFoundException;
      public Item findByItemId(int itemId) throws ItemNotFoundException;
      public Item updateItemDetails(int itemId, Item item) throws ItemNotFoundException;
      public Cart getCartOfItem(int itemId) throws ItemNotFoundException;

}