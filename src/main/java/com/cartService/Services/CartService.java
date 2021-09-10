package com.cartService.Services;

import com.cartService.Entities.Cart;
import com.cartService.Exceptions.CartNotFoundException;
import com.cartService.Exceptions.CustomerNameNotFoundException;

public interface CartService {


    public Cart createCart(Cart cart);
    public boolean deleteCart(int cartId);
    public Cart findBYCartId(int cartId) throws CartNotFoundException;
    public Cart findByCustomerName(String CustomerName) throws CustomerNameNotFoundException;

}
