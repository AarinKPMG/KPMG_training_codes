package com.example.SpringMVCBoot.controller;

import com.example.SpringMVCBoot.beans.Product;
import com.example.SpringMVCBoot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/search")
    public String showSearchProductsToUser(@RequestParam("search")
                                                String search , Model model ){
        System.out.println("user is looking for - "+search);

        List<Product> products = new ArrayList<>();
        products = productRepository.searchByName(search);
        model.addAttribute("products",products);

        return "search";
    }
}
