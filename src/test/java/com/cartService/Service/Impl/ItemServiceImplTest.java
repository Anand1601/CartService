package com.cartService.Service.Impl;

import com.cartService.Daos.ItemDao;
import com.cartService.Services.Impl.ItemServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemServiceImplTest {

    @Mock
    ItemDao itemDao;

    @InjectMocks
    ItemServiceImpl itemService;





}
