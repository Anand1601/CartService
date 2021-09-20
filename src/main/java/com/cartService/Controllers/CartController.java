package com.cartService.Controllers;

import com.cartService.DTOs.CartDTO;
import com.cartService.DTOs.ItemDTO;
import com.cartService.Entities.Cart;
import com.cartService.Entities.Item;
import com.cartService.Exceptions.CartNotFoundException;
import com.cartService.Exceptions.CustomerNameNotFoundException;
import com.cartService.Exceptions.ItemNotFoundException;
import com.cartService.Services.CartService;
import com.cartService.Services.ItemService;
import com.cartService.utils.DTOEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;

@RestController
/*
* 127.0.0.1.8080/cartService/v1/carts
* */
@RequestMapping("/carts")
public class CartController {


    @Autowired
    private CartService cartService;

    @Autowired
    private ItemService itemService;


 /*
    * endpoint to create the cart
    *
    * POST 127.0.0.1:8080/cartService/v1/carts
    * */
    @PostMapping
    public ResponseEntity createCart(@RequestBody CartDTO cartDTO)
    {
         Cart cart =cartService.createCart(DTOEntityMapper.convertCartDTOToCartEntity(cartDTO));
         CartDTO cartResponse = DTOEntityMapper.convertCartEntityToCartDTO(cart);
         return new ResponseEntity(cartResponse,HttpStatus.CREATED);
    }


     /*
     * search a cort based on the cartId
     *
     * GET 127.0.01:8080/cartService/v1/carts/{cart_id}
     * */
    @GetMapping("/{cart_id}")
    public  ResponseEntity getCart(@PathVariable("cart_id") int cartId) throws CartNotFoundException {
        Cart cart = cartService.findByCartId(cartId);
        CartDTO cartResponse = DTOEntityMapper.convertCartEntityToCartDTO(cart);
         return new ResponseEntity(cartResponse,HttpStatus.OK);

    }

     /*
     * add item in cort
     *
     * POST 127.0.01:8080/cartService/v1/carts/{cart_id}
     * */
    @PostMapping("/{cart_id}")
    public ResponseEntity addItemToCart(@RequestBody ItemDTO itemDTO , @PathVariable("cart_id")int cartId) throws CartNotFoundException, ItemNotFoundException {
        Cart cart =  cartService.addItemToTheCart(DTOEntityMapper.convertItemDTOToItemEntity(itemDTO),cartId);

        CartDTO cartDTO = DTOEntityMapper.convertCartEntityToCartDTO(cart);
        return new ResponseEntity(cartDTO,HttpStatus.CREATED);

    }


    /*
     * get all items of the cart based on the cartId
     *
     * GET 127.0.01:8080/cartService/v1/carts/{cart_id}
     * */
    @GetMapping("/{cart_id}/items")
    public ResponseEntity listOfItemsOfTheCart(@PathVariable("cart_id")int cartId) throws CartNotFoundException {
        List<Item> list = cartService.getItemsOfTheCart(cartId);
        List<ItemDTO> listOfItems = new ArrayList<>();
        for(Item item:list)
            listOfItems.add(DTOEntityMapper.convertItemEntityToItemDTO(item));
        return new ResponseEntity(listOfItems,HttpStatus.OK);
    }

    /*
     * delete cart based on the cartId
     *
     *DELETE 127.0.01:8080/cartService/v1/carts/{cart_id}
     * */
    @DeleteMapping("/{cart_id}")
    public ResponseEntity deleteCart(@PathVariable("cart_id")int cartId) throws CartNotFoundException {
        cartService.deleteCart(cartId);
        return new ResponseEntity("DELETED",HttpStatus.OK);
    }

    /*
     * get cart based on the customer name
     *
     * GET 127.0.01:8080/cartService/v1/carts/customer_name/{customer_name}
     * */
    @GetMapping("/customer_name/{customer_name}")
    public ResponseEntity getCartByCustomerName(@PathVariable("customer_name")String customerName) throws CustomerNameNotFoundException {
        Cart cart = cartService.findByCustomerName(customerName);
        return new ResponseEntity(cart,HttpStatus.OK);
    }


}
