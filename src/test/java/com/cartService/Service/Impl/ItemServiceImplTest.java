package com.cartService.Service.Impl;

import com.cartService.Daos.CartDao;
import com.cartService.Daos.ItemDao;
import com.cartService.Entities.Cart;
import com.cartService.Entities.Item;
import com.cartService.Exceptions.CartNotFoundException;
import com.cartService.Exceptions.ItemNotFoundException;
import com.cartService.Services.Impl.CartServiceImpl;
import com.cartService.Services.Impl.ItemServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class ItemServiceImplTest {

    @Mock
    ItemDao itemDaoMock;

    @InjectMocks
    ItemServiceImpl itemService;


    @Mock
    CartDao cartDaoMock;

    @InjectMocks
    CartServiceImpl cartService;

/*
* Test createItem
* */
    @Test
     public void testCreateItem() throws CartNotFoundException {


     Item item = new Item();
     item.setItemName("iphone");
     item.setMfgDate(LocalDateTime.of(2020,10,14,2,0));
     item.setItemDescription("it is an electronic device");
     item.setCost(51000);
     item.setCategory("electronics");



     Mockito.when(itemDaoMock.save(item)).thenReturn(item);

     Item saveItem = itemService.createItem(item);

        Assertions.assertNotNull(saveItem);


     }


     /*
     * test updateItemDetails
     * */
     @Test
     public void testUpdateItemDetails() throws ItemNotFoundException {

     Item item = new Item();
     item.setItemName("iphone");
     item.setMfgDate(LocalDateTime.of(2020,10,14,2,0));
     item.setItemDescription("it is an electronic device");
     item.setCost(51000);
     item.setCategory("electronics");

     Mockito.when(itemDaoMock.findById(1)).thenReturn(Optional.of(item));
     Mockito.when(itemDaoMock.save(item)).thenReturn(item);

     Item updatedItem = itemService.updateItemDetails(1,item);


     Assertions.assertNotNull(updatedItem);
     Assertions.assertEquals(item.getItemId(),updatedItem.getItemId());

     }


     @Test
    public void testGetCartOfItem() throws ItemNotFoundException {
         Cart cart = new Cart();
         cart.setCustomerName("anand");
           Item item = new Item();
           item.setCart(cart);
     item.setItemName("iphone");
     item.setMfgDate(LocalDateTime.of(2020,10,14,2,0));
     item.setItemDescription("it is an electronic device");
     item.setCost(51000);
     item.setCategory("electronics");

     Mockito.when(itemDaoMock.findById(1)).thenReturn(Optional.of(item));

     Cart cart1 = itemService.getCartOfItem(1);

     Assertions.assertNotNull(cart1);

    }




}
