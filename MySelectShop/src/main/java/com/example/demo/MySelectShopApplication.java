package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // ������ ��Ʈ���� �����ٷ��� �۵��ϰ� �Ѵ�.
@EnableJpaAuditing // �ð� �ڵ� ������ �����ϵ��� �Ѵ�.
@SpringBootApplication // ������ ��Ʈ���� �����Ѵ�.
public class MySelectShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySelectShopApplication.class, args);
	}

}
