package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // get 함수를 일괄적으로 만들어준다.
@NoArgsConstructor // 기본 생성자를 만들어준다.
@Entity // DB 테이블 역할을 한다.
public class Product extends Timestamped{

		// ID가 자동으로 생성 및 증가한다.
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Id
    private Long id;

		// 반드시 값을 가지도록 한다.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;
    
    // 관심 상품 생성 시 이용한다.
    public Product(ProductRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.image = requestDto.getImage();
        this.link = requestDto.getLink();
        this.lprice = requestDto.getLprice();
        this.myprice = 0;
    }
    // 관심 가격 변경 시 이용한다.
	public void update(ProductMypriceRequestDto requestDto) {
         this.myprice = requestDto.getMyprice();
	}
	public void updateByItemDto(ItemDto itemDto) {
		this.lprice = itemDto.getLprice();		
	}
}