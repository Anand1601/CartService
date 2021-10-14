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

        public Item createItem(Item item)  {
            logger.info("adding a new item to the DB");
            return itemDao.save(item);
        }

    @Override
    public Item findByItemId(int itemId) throws ItemNotFoundException {
            logger.info("finding an item by item id:"+itemId);
        return itemDao.findById(itemId).orElseThrow(()->new ItemNotFoundException());
    }

    @Override
    public Item updateItemDetails(int itemId, Item item) throws ItemNotFoundException {

            logger.info("updating an item with item id:"+itemId);

     Item savedItem = itemDao.findById(itemId).orElseThrow(()->new ItemNotFoundException());

     savedItem.setItemName(item.getItemName());
     savedItem.setItemDescription(item.getItemDescription());
     savedItem.setCategory(item.getCategory());
     savedItem.setCost(item.getCost());
     savedItem.setCart(item.getCart());
     savedItem.setMfgDate(item.getMfgDate());

        logger.info("item details are updated successfully");
     return itemDao.save(savedItem);
    }

    @Override
    public List<Item> getAllItem() {
        return itemDao.findAll();
    }


}
