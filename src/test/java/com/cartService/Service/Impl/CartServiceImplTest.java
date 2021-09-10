package com.cartService.Service.Impl;

import com.cartService.Daos.CartDao;
import com.cartService.Entities.Cart;
import com.cartService.Exceptions.CartNotFoundException;
import com.cartService.Services.Impl.CartServiceImpl;
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

    @Test
    public void testFindByCartIdThrowsExceptions() throws CartNotFoundException {

        Cart cart1 = new Cart();
        cart1.setCustomerName("vivek");
        cart1.setCartId(1);

        Mockito.when(cartDaoMock.findById(1)).thenThrow(new CartNotFoundException());

        Cart cart =cartService.findBYCartId(1);

    }
}
