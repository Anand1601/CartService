package com.cartService.Services.Impl;

import com.cartService.Daos.CartDao;
import com.cartService.Entities.Cart;
import com.cartService.Exceptions.CartNotFoundException;
import com.cartService.Exceptions.CustomerNameNotFoundException;
import com.cartService.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    @Override
    public Cart createCart(Cart cart) {
       return cartDao.save(cart);
    }

    @Override
    public boolean deleteCart(int cartId) {
        cartDao.deleteById(cartId);
        return  true;
    }

    @Override
    public Cart findBYCartId(int cartId) throws CartNotFoundException {
        return cartDao.findById(cartId).orElseThrow(() -> new CartNotFoundException());


    }

    @Override
    public Cart findByCustomerName(String customerName) throws CustomerNameNotFoundException {
        Cart cart = cartDao.findByCustomerName(customerName);

        if(cart==null)
            throw new CustomerNameNotFoundException();
        return cart;
    }
}
