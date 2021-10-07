package com.cartService.Service.Impl;

import com.cartService.Daos.CartDao;
import com.cartService.Daos.ItemDao;
import com.cartService.Entities.Cart;
import com.cartService.Entities.Item;
import com.cartService.Exceptions.CartNotFoundException;
import com.cartService.Exceptions.CustomerNameAlreadyExistsException;
import com.cartService.Exceptions.CustomerNameNotFoundException;
import com.cartService.Services.Impl.CartServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CartServiceImplTest {

    @Mock
    CartDao cartDaoMock;

    @InjectMocks
    CartServiceImpl cartService;


    @Mock
    ItemDao itemDao;

    @InjectMocks
    ItemServiceImplTest itemService;



    /*
    * Test for CreateCart
    * */
    @Test
    public void testCreateCart() throws CustomerNameNotFoundException, CustomerNameAlreadyExistsException {
        Cart cart = new Cart();
        cart.setCustomerName("anand bharti");

        Cart cart1 = new Cart();
        cart1.setCustomerName("vivek");
        cart1.setCartId(1);

        Mockito.when(cartDaoMock.save(cart)).thenReturn(cart1);

        Cart savedCart = cartService.createCart(cart);

        Assertions.assertNotNull(savedCart);
        Assertions.assertEquals(cart1,savedCart);


    }



/*
* Test for findByCartId
* */
    @Test
    public void testFindByCartId() throws CartNotFoundException {

        Cart cart1 = new Cart();
        cart1.setCustomerName("vivek");
        cart1.setCartId(1);

        Mockito.when(cartDaoMock.findById(1)).thenReturn(Optional.of(cart1));
        Cart cart = cartService.findByCartId(1);

        Assertions.assertNotNull(cart);
        Assertions.assertEquals("vivek",cart.getCustomerName());

    }


    /*
    * Test for deleteCart
    * */
    @Test
    public void testDeleteCart() throws CartNotFoundException {
        Mockito.doNothing().when(cartDaoMock).deleteById(1);

        boolean deleteResult = cartService.deleteCart(1);

        Assertions.assertTrue(deleteResult);


    }



    /*
    * Test findByCustomerName
    * */
        @Test
        public void  findByCustomerName() throws CustomerNameNotFoundException {

        Cart cart1 = new Cart();
        cart1.setCustomerName("vivek");
        cart1.setCartId(1);

        Mockito.when(cartDaoMock.findByCustomerName("vivek")).thenReturn(cart1);

        Cart cart = cartService.findByCustomerName("vivek");

        Assertions.assertNotNull(cart);
        Assertions.assertEquals("vivek",cart.getCustomerName());

        }

      /*
      * test getItemsOfTheCart
      * */

    @Test
    public void testGetItemsOfTheCart() throws CartNotFoundException {

        Cart cart = new Cart();
        cart.setCartId(1);
        cart.setCustomerName("anand");
        Item item = new Item();
        item.setCart(cart);
        item.setCategory("electronics");
        item.setItemDescription("it is an smartphone");
        item.setItemName("iphone");
        item.setCost(51000);
        item.setMfgDate(LocalDateTime.of(2020,11,12,3,0));

        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        cart.setItems(itemList);
        Mockito.when(cartDaoMock.findById(1)).thenReturn(Optional.of(cart));

        List<Item> items = cartService.getItemsOfTheCart(1);


        Assertions.assertNotNull(items);
        Assertions.assertNotEquals(0,items.size());
    }





    }

