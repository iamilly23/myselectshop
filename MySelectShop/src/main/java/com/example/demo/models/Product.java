package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // get �Լ��� �ϰ������� ������ش�.
@NoArgsConstructor // �⺻ �����ڸ� ������ش�.
@Entity // DB ���̺� ������ �Ѵ�.
public class Product extends Timestamped{

		// ID�� �ڵ����� ���� �� �����Ѵ�.
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Id
    private Long id;

		// �ݵ�� ���� �������� �Ѵ�.
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
    
    // ���� ��ǰ ���� �� �̿��Ѵ�.
    public Product(ProductRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.image = requestDto.getImage();
        this.link = requestDto.getLink();
        this.lprice = requestDto.getLprice();
        this.myprice = 0;
    }
    // ���� ���� ���� �� �̿��Ѵ�.
	public void update(ProductMypriceRequestDto requestDto) {
         this.myprice = requestDto.getMyprice();
	}
	public void updateByItemDto(ItemDto itemDto) {
		this.lprice = itemDto.getLprice();		
	}
}