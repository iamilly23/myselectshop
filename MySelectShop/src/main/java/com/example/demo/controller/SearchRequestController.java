package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ItemDto;
import com.example.demo.utils.NaverShopSearch;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final �� ����� Ŭ������ �ڵ����� �����Ѵ�.
@RestController // JSON���� �������� �����Ѵ�.
public class SearchRequestController {

    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")
    public List<ItemDto> getItems(@RequestParam String query) {
        String resultString = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItems(resultString);
    }
}