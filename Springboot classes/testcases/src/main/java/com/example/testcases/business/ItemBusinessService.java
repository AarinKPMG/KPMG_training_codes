package com.example.testcases.business;

import com.example.testcases.model.Item;
import com.example.testcases.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository ;

    public Item retrieveHardCodedItem(){
        return new Item(1,"Ball",10,100);
    }

    public List<Item> retrieveAllItems(){
        List<Item> items = itemRepository.findAll();

        for(Item i : items){
            i.setValue( i.getPrice() * i.getQuantity() );
        }

        return items ;
    }

}
