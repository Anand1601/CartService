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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

     public static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    @Autowired
    CartDao cartDao;

    @Autowired
    ItemService itemService;

    @Override
    public Cart createCart(Cart cart) throws CustomerNameAlreadyExistsException {

        logger.info("new cart is being created");

        if(cartDao.findByCustomerName(cart.getCustomerName())!=null) {
            logger.error("Customer Name already exist");
            throw new CustomerNameAlreadyExistsException();
        }
        return cartDao.save(cart);
    }

    @Override
    public boolean deleteCart(int cartId) throws CartNotFoundException {

        logger.info("cart with cart id:"+cartId+" is being deleted");

        if(cartDao.findById(cartId).isPresent())
        cartDao.deleteById(cartId);
        else {
            logger.error("cart with cart id:"+cartId+" not found for deletion");
            throw new CartNotFoundException();
        }
        return  true;
    }

    @Override
    public Cart getCartByCartId(int cartId) throws CartNotFoundException {

        logger.info("getting the cart with cart id:"+cartId);
        return cartDao.findById(cartId).orElseThrow(() -> new CartNotFoundException());

    }

    @Override
    public Cart getCartByCustomerName(String customerName) throws CustomerNameNotFoundException {

        logger.info("getting the cart with customer name:"+customerName);
        Cart cart = cartDao.findByCustomerName(customerName);

        if(cart==null) {
        logger.error("No cart found for customer name:"+customerName);
            throw new CustomerNameNotFoundException();
        }
        return cart;
    }

    @Override
    public List<Item> getItemsOfTheCart(int cartId) throws CartNotFoundException {
        Cart cart = cartDao.findById(cartId).orElseThrow(()-> new CartNotFoundException());
        return cart.getItems();
    }

    @Override
    public Cart addItemToTheCart(int itemId, int cartId) throws CartNotFoundException, ItemNotFoundException {

        logger.info("adding an item with item id:"+itemId +" to the cart with cart id:"+cartId);

        Item item = itemService.findByItemId(itemId);
        Cart cart = cartDao.findById(cartId).orElseThrow(()->new CartNotFoundException());
        Item saveItem = itemService.createItem(item);
        item.setCart(cart);
        cart.getItems().add(saveItem);
       return cartDao.save(cart);

    }


}
