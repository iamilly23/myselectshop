package com.example.demo.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.models.ItemDto;
import com.example.demo.models.Product;
import com.example.demo.models.ProductRepository;
import com.example.demo.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 멤버 변수를 자동으로 생성한다.
@Component // 스프링이 필요 시 자동으로 생성하는 클래스 목록에 추가한다.
public class Scheduler {

    private final ProductRepository productRepository;
    private final ProductService productService;
    private final NaverShopSearch naverShopSearch;

    // 초, 분, 시, 일, 월, 주 순서
    @Scheduled(cron = "0 0 1 * * *")
    public void updatePrice() throws InterruptedException {
        System.out.println("가격 업데이트 실행");
        // 저장된 모든 관심상품을 조회한다.
        List<Product> productList = productRepository.findAll();
        for (int i=0; i<productList.size(); i++) {
            // 1초에 한 상품 씩 조회한다 (Naver 제한)
            TimeUnit.SECONDS.sleep(1);
            // i 번째 관심 상품을 꺼낸다.
            Product p = productList.get(i);
            // i 번째 관심 상품의 제목으로 검색을 실행한다.
            String title = p.getTitle();
            String resultString = naverShopSearch.search(title);
            // i 번째 관심 상품의 검색 결과 목록 중에서 첫 번째 결과를 꺼낸다.
            List<ItemDto> itemDtoList = naverShopSearch.fromJSONtoItems(resultString);
            ItemDto itemDto = itemDtoList.get(0);
            // i 번째 관심 상품 정보를 업데이트한다.
            Long id = p.getId();
            productService.updateBySearch(id, itemDto);
        }
    }
}