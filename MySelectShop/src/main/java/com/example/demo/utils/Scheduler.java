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

@RequiredArgsConstructor // final ��� ������ �ڵ����� �����Ѵ�.
@Component // �������� �ʿ� �� �ڵ����� �����ϴ� Ŭ���� ��Ͽ� �߰��Ѵ�.
public class Scheduler {

    private final ProductRepository productRepository;
    private final ProductService productService;
    private final NaverShopSearch naverShopSearch;

    // ��, ��, ��, ��, ��, �� ����
    @Scheduled(cron = "0 0 1 * * *")
    public void updatePrice() throws InterruptedException {
        System.out.println("���� ������Ʈ ����");
        // ����� ��� ���ɻ�ǰ�� ��ȸ�Ѵ�.
        List<Product> productList = productRepository.findAll();
        for (int i=0; i<productList.size(); i++) {
            // 1�ʿ� �� ��ǰ �� ��ȸ�Ѵ� (Naver ����)
            TimeUnit.SECONDS.sleep(1);
            // i ��° ���� ��ǰ�� ������.
            Product p = productList.get(i);
            // i ��° ���� ��ǰ�� �������� �˻��� �����Ѵ�.
            String title = p.getTitle();
            String resultString = naverShopSearch.search(title);
            // i ��° ���� ��ǰ�� �˻� ��� ��� �߿��� ù ��° ����� ������.
            List<ItemDto> itemDtoList = naverShopSearch.fromJSONtoItems(resultString);
            ItemDto itemDto = itemDtoList.get(0);
            // i ��° ���� ��ǰ ������ ������Ʈ�Ѵ�.
            Long id = p.getId();
            productService.updateBySearch(id, itemDto);
        }
    }
}