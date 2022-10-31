package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.models.ItemDto;
import com.example.demo.models.Product;
import com.example.demo.models.ProductMypriceRequestDto;
import com.example.demo.models.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final�� ����� ��� ������ �ڵ����� �����Ѵ�.
@Service // �������� �����Ѵ�.
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional // �޼ҵ� ������ SQL ���������� �����Ѵ�.
    public Long update(Long id, ProductMypriceRequestDto requestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("�ش� ���̵� �������� �ʽ��ϴ�.")
        );
        product.update(requestDto);
        return id;
    }
    
    @Transactional // �޼ҵ� ������ SQL ���������� �����Ѵ�.
    public Long updateBySearch(Long id, ItemDto itemDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("�ش� ���̵� �������� �ʽ��ϴ�.")
        );
        product.updateByItemDto(itemDto);
        return id;
    }
}
