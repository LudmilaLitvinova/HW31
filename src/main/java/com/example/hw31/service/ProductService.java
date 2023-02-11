package com.example.hw31.service;

import com.example.hw31.dto.ProductDto;
import com.example.hw31.model.Product;
import com.example.hw31.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Ludmila Litvinova on 11.02.23
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    public void addProduct(ProductDto productDto) {
        Product product = objectMapper.convertValue(productDto, Product.class);
        productRepository.save(product);
        productDto.setId(product.getId());
    }
    public List<ProductDto> getAllProducts() {
        List<ProductDto> listDto = new ArrayList<>();
        Iterable<Product> products = productRepository.findAll();
        for (Product product : products) {
            listDto.add(objectMapper.convertValue(product, ProductDto.class));
        }
        return listDto;
    }

    public ProductDto getProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return objectMapper.convertValue(product, ProductDto.class);

    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }
}
