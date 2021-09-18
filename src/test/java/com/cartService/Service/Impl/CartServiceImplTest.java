package com.cartService.Service.Impl;

import com.cartService.Daos.CartDao;
import com.cartService.Entities.Cart;
import com.cartService.Exceptions.CartNotFoundException;
import com.cartService.Exceptions.CustomerNameNotFoundException;
import com.cartService.Services.Impl.CartServiceImpl;
import java.util.Optional;

import org.junit.Assert;
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

    /*
    * Test for CreateCart
    * */
    @Test
    public void testCreateCart(){
        Cart cart = new Cart();
        cart.setCustomerName("anand bharti");

        Cart cart1 = new Cart();
        cart1.setCustomerName("vivek");
        cart1.setCartId(1);

        Mockito.when(cartDaoMock.save(cart)).thenReturn(cart1);

        Cart savedCart = cartService.createCart(cart);

        //testing
        Assertions.assertNotNull(savedCart);
        Assertions.assertEquals(1,savedCart.getCartId());


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
        Cart cart = cartService.findBYCartId(1);

        Assertions.assertNotNull(cart);
        Assertions.assertEquals("vivek",cart.getCustomerName());

    }


    /*
    * Test for deleteCart
    * */
    @Test
    public void testDeleteCart(){
        //data


        //Mock -- When we have to mack a method that returns nothing
        Mockito.doNothing().when(cartDaoMock).deleteById(1);

        //Execution
        boolean deleteResult = cartService.deleteCart(1);

        //Assertion
        Assert.assertTrue(deleteResult);


    }


    /*
    * Test for FindByCartIdThrowsException
    * */
    @Test
    public void testFindByCartIdThrowsExceptions(){
//in this we have forcefully thrown the exception by returning Optional.empty();
        Cart cart1 = new Cart();
        cart1.setCustomerName("vivek");
        cart1.setCartId(1);

        Mockito.when(cartDaoMock.findById(1)).thenReturn(Optional.empty());


        try {
            Cart cart = cartService.findBYCartId(1);
        } catch (Exception e) {
            Assertions.assertEquals(CartNotFoundException.class, e.getClass());
        }

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





    }

