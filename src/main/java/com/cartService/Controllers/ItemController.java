package com.cartService.Controllers;

import com.cartService.DTOs.ItemDTO;
import com.cartService.Daos.ItemDao;
import com.cartService.Entities.Item;
import com.cartService.Exceptions.CartNotFoundException;
import com.cartService.Exceptions.ItemNotFoundException;
import com.cartService.Services.ItemService;
import com.cartService.utils.DTOEntityMapper;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/*
* 127.0.0.1.8080/cartService/v1/items
* */
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    /*
    * end point for creating item
    *
    * POST 127.0.0.1.8080/cartService/v1/items
    * */
    @PostMapping
    public ResponseEntity createItem(@RequestBody ItemDTO itemDTO) throws CartNotFoundException {
        Item item = itemService.createItem(DTOEntityMapper.convertItemDTOToItemEntity(itemDTO));
        ItemDTO itemResponse = DTOEntityMapper.convertItemEntityToItemDTO(item);
        return new ResponseEntity(itemResponse, HttpStatus.CREATED);
    }

     /*
    * end point to get an item based on itemId
    *
    * GET 127.0.0.1.8080/cartService/v1/items/{item_id}
    * */
    @GetMapping("/{item_id}")
    public ResponseEntity getItem(@PathVariable("item_id") int itemId) throws ItemNotFoundException {
        Item item = itemService.findByItemId(itemId);
        ItemDTO itemResponse = DTOEntityMapper.convertItemEntityToItemDTO(item);

        return new ResponseEntity(itemResponse,HttpStatus.OK);
    }

     /*
    * end point to update item details
    *
    * PUT 127.0.0.1.8080/cartService/v1/items/{item_id}
    * */
    @PutMapping("/{item_id}")
    public  ResponseEntity updateItemDetail(@PathVariable("item_id") int itemId,@RequestBody ItemDTO itemDTO) throws ItemNotFoundException {
        Item item = itemService.updateItemDetails(itemId,DTOEntityMapper.convertItemDTOToItemEntity(itemDTO));
        ItemDTO itemResponse = DTOEntityMapper.convertItemEntityToItemDTO(item);
        return new ResponseEntity(itemResponse,HttpStatus.OK);
    }

    /*
    * end point to get cart of item
    *
    * GET 127.0.0.1.8080/cartService/v1/items/{item_id}/cart
    * */
    @GetMapping("/{item_id}/cart")
    public ResponseEntity getCartOfItem(@PathVariable("item_id")int itemId) throws ItemNotFoundException {
        int cartId = itemService.getCartOfItem(itemId);
        return new ResponseEntity("cart of item with itemId"+itemId+": "+cartId,HttpStatus.OK);
    }


}
