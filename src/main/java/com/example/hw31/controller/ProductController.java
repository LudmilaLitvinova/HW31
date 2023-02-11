package com.example.hw31.controller;

import com.example.hw31.dto.ProductDto;
import com.example.hw31.model.ProductItem;
import com.example.hw31.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liudmyla Litvinova on 11.02.23
 */
@Controller
@RequestMapping("products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String getAllProducts(Model model) {
        log.info("List of products");
        model.addAttribute("title", "All Products");
        model.addAttribute("listProducts", productService.getAllProducts());
        return "products";
    }

    @GetMapping("add")
    public String addProducts(Model model) {
        log.info("Add products page");
        model.addAttribute("productForm", new ProductItem());
        return "add";
    }

    @GetMapping("{id}/delete")
    public String deleteProduct(Model model, @PathVariable int id) {
        log.info("Delete Product");
        productService.deleteProduct(id);
        model.addAttribute("listProducts", productService.getAllProducts());
        return "redirect:/products";
    }


    @PostMapping("add")
    public String saveProductDetails(Model model, @ModelAttribute("productForm") ProductItem productItem) {
        log.info("Save product details");

        List<String> validationErrors = new ArrayList<>();
        if (productItem.getName() == null || productItem.getName().isEmpty()) {
            validationErrors.add("Name is required");
        }

        if (productItem.getCost() == null) {
            validationErrors.add("Cost is required");
        }

        if (!validationErrors.isEmpty()) {
            model.addAttribute("errorMsgs", validationErrors);

            return "add";
        }

        productService.addProduct(new ProductDto(null, productItem.getName(), productItem.getCost()));
        return "redirect:/products";

    }

    @GetMapping("{id}")
    public String getProductById(Model model, @PathVariable int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID < 0");
        }
        model.addAttribute("product", productService.getProductById(id));
        return "details";
    }

}
