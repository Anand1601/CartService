package com.cartService.Daos;

import com.cartService.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Integer> {

}
