package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ItemDto;
import com.example.demo.utils.NaverShopSearch;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 로 선언된 클래스를 자동으로 생성한다.
@RestController // JSON으로 응답함을 선언한다.
public class SearchRequestController {

    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")
    public List<ItemDto> getItems(@RequestParam String query) {
        String resultString = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItems(resultString);
    }
}
