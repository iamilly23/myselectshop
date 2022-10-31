package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Product;
import com.example.demo.models.ProductMypriceRequestDto;
import com.example.demo.models.ProductRepository;
import com.example.demo.models.ProductRequestDto;
import com.example.demo.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final�� ����� ��� ������ �ڵ����� �����Ѵ�.
@RestController // JSON���� �����͸� �ְ������ �����Ѵ�.
public class ProductRestController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    // ��ϵ� ��ü ��ǰ ��� ��ȸ
    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    
    // �ű� ��ǰ ���
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto) {
        Product product = new Product(requestDto);
        productRepository.save(product);
        return product;
    }
    // ���� ���� ����
    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) {
        return productService.update(id, requestDto);
    }
}
