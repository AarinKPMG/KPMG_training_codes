package com.example.testcases.business;

import com.example.testcases.model.Item;
import com.example.testcases.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService business ;

    @Mock
    private ItemRepository itemRepository ;

    @Test
    public void retrieveAllItems_basic(){
        when(itemRepository.findAll())
                .thenReturn(Arrays.asList(new Item(10003,"santoor",400,35),
                        new Item(10002 , "LUX" , 200 , 15)));

        List<Item> items = business.retrieveAllItems();

        assertEquals(14000, items.get(0).getValue());
        assertNotEquals(3000 , items.get(0).getValue() );
    }

}
