package com.example.testcases.controller;

import com.example.testcases.business.ItemBusinessService;
import com.example.testcases.model.Item;
import com.example.testcases.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService ;

    @GetMapping("/dummy-item")
    public Item getDummyItem(){
        return new Item(10004 , "lifeBoy" , 20 , 350 );
    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems(){
        return itemBusinessService.retrieveAllItems();
    }

}

