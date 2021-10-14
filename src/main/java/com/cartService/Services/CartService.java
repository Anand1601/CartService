package com.cartService.Services;

import com.cartService.Entities.Cart;
import com.cartService.Entities.Item;
import com.cartService.Exceptions.CartNotFoundException;
import com.cartService.Exceptions.CustomerNameAlreadyExistsException;
import com.cartService.Exceptions.CustomerNameNotFoundException;
import com.cartService.Exceptions.ItemNotFoundException;

import java.util.List;

public interface CartService {


    public Cart createCart(Cart cart) throws CustomerNameAlreadyExistsException;
    public boolean deleteCart(int cartId) throws CartNotFoundException;
    public Cart getCartByCartId(int cartId) throws CartNotFoundException;
    public Cart getCartByCustomerName(String CustomerName) throws CustomerNameNotFoundException;
    public List<Item> getItemsOfTheCart(int cartId) throws CartNotFoundException;
    public Cart addItemToTheCart(int itemId,int cartId) throws ItemNotFoundException, CartNotFoundException;
}
