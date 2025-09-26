package com.example.demo_spring.product_db.controller;

import com.example.demo_spring.product_db.entity.Product;
import com.example.demo_spring.product_db.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/addProduct")
    public String addProductForm(Model model){
        model.addAttribute("product",new Product());
        return "addProduct";
    }
    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product, Model model) {
        productService.saveProduct(product);

        // Add success message
        model.addAttribute("message", "Product added successfully!");

        // Return to addProduct form page
        return "addProduct";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute Product product){
        productService.saveProduct(product);
        return "redirect:/addProduct";
    }

    @GetMapping("/displayProducts")
    public String displayProducts(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "displayProducts";
    }
}
