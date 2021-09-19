package com.cartService.utils;

import com.cartService.DTOs.CartDTO;
import com.cartService.DTOs.ItemDTO;
import com.cartService.Entities.Cart;
import com.cartService.Entities.Item;

public class DTOToEntityConvertor {

    public static Cart convertCartDTOToCartEntity(CartDTO cartDTO){

        Cart cart = new Cart();
        cart.setCartId(cartDTO.getCartId());
        cart.setCustomerName(cartDTO.getCustomerName());
        for(ItemDTO itemDTO:cartDTO.getItems())
        {
            cart.getItems().add(convertItemDTOToItemEntity(itemDTO));
        }

        return cart;
    }

    private static Item convertItemDTOToItemEntity(ItemDTO itemDTO) {
        Item item = new Item();
        item.setItemName(itemDTO.getItemName());
        item.setItemDescription(itemDTO.getItemDescription());
        item.setCost(itemDTO.getCost());
        item.setCategory(itemDTO.getCategory());
        item.setMfgDate(itemDTO.getMfgDate());
        item.setItemId(item.getItemId());

        return item;
    }

    public static CartDTO convertCArtEntityToCartDTO(Cart cart)
    {
          CartDTO cartDTO = new CartDTO();
        cartDTO.setCartId(cart.getCartId());
        cartDTO.setCustomerName(cart.getCustomerName());
        for(Item item:cart.getItems())
        {
            cartDTO.getItems().add(convertItemEntityToItemDTO(item));
        }

        return cartDTO;
    }

    private static ItemDTO convertItemEntityToItemDTO(Item item) {

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setItemId(item.getItemId());
        itemDTO.setItemName(item.getItemName());
        itemDTO.setItemDescription(item.getItemDescription());
        itemDTO.setCategory(item.getCategory());
        itemDTO.setCost(item.getCost());
        itemDTO.setMfgDate(item.getMfgDate());

    }

}
