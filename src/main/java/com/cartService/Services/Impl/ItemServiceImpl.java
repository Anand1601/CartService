package com.cartService.Services.Impl;

import com.cartService.Daos.ItemDao;
import com.cartService.Entities.Cart;
import com.cartService.Entities.Item;
import com.cartService.Exceptions.CartNotFoundException;
import com.cartService.Exceptions.ItemNotFoundException;
import com.cartService.Services.CartService;
import com.cartService.Services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {


    public static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);


    @Autowired
    ItemDao itemDao;

    @Autowired
    CartService cartService;

        public Item addItemCart(Item item, int cartId) throws CartNotFoundException {

            logger.debug("Arguments passed are: "+item+"and cart id: "+cartId);
            logger.info("Getting inside the addItemToCart method");

            Cart cart = cartService.findBYCartId(cartId);
            item.setCart(cart);

            logger.info("Returning from the addItemToCart method");

            return itemDao.save(item);
        }

    public Cart getCartOfItem(int itemId) throws ItemNotFoundException {

            Item item = itemDao.findById(itemId).orElseThrow(()-> new ItemNotFoundException());

            /*
            * Item -> Cart : Many to One : Egger Initialization
            * */
        return item.getCart();

    }

    public List<Item> getItemsFromTheCart(int cartId) throws CartNotFoundException{

            Cart cart = cartService.findBYCartId(cartId);
            //cart -> item :by defoult it is Lazy initialization as cart initialized but it has no items, so we do this by:-


        return itemDao.findItemsByCart(cart);

    }


}
