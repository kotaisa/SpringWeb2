package com.example.lesson.Controller;

import com.example.lesson.service.PgProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class TestController {

    @Autowired
    PgProductService pgProductService;

    @GetMapping("/product-list")
    public String productList(Model model) {
        model.addAttribute("products", pgProductService.findAll());
        return "findAll";
    }

    @GetMapping("/product/{id}")
    public String findProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", pgProductService.findById(id));
        return "findByid";
    }
}