package com.cartService.Services.Impl;

import com.cartService.Daos.CartDao;
import com.cartService.Entities.Cart;
import com.cartService.Entities.Item;
import com.cartService.Exceptions.CartNotFoundException;
import com.cartService.Exceptions.CustomerNameAlreadyExistsException;
import com.cartService.Exceptions.CustomerNameNotFoundException;
import com.cartService.Exceptions.ItemNotFoundException;
import com.cartService.Services.CartService;
import com.cartService.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    @Autowired
    ItemService itemService;

    @Override
    public Cart createCart(Cart cart) throws CustomerNameAlreadyExistsException {
        if(cartDao.findByCustomerName(cart.getCustomerName())!=null)
            throw new CustomerNameAlreadyExistsException();
        return cartDao.save(cart);
    }

    @Override
    public boolean deleteCart(int cartId) throws CartNotFoundException {
        if(cartDao.findById(cartId).isPresent())
        cartDao.deleteById(cartId);
        else
            throw new CartNotFoundException();
        return  true;
    }

    @Override
    public Cart findByCartId(int cartId) throws CartNotFoundException {
        return cartDao.findById(cartId).orElseThrow(() -> new CartNotFoundException());


    }

    @Override
    public Cart findByCustomerName(String customerName) throws CustomerNameNotFoundException {
        Cart cart = cartDao.findByCustomerName(customerName);

        if(cart==null)
            throw new CustomerNameNotFoundException();
        return cart;
    }

    @Override
    public List<Item> getItemsOfTheCart(int cartId) throws CartNotFoundException {
        Cart cart = cartDao.findById(cartId).orElseThrow(()-> new CartNotFoundException());
        return cart.getItems();
    }

    @Override
    public Cart addItemToTheCart(Item item, int cartId) throws CartNotFoundException {
        Cart cart = cartDao.findById(cartId).orElseThrow(()->new CartNotFoundException());
        Item saveItem = itemService.createItem(item);
        item.setCart(cart);
        cart.getItems().add(saveItem);
       return cartDao.save(cart);

    }


}
