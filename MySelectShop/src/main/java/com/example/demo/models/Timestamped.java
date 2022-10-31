package com.example.demo.models;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter // get �Լ��� �ڵ� �����Ѵ�.
@MappedSuperclass // ��� ������ �÷��� �ǵ��� �Ѵ�.
@EntityListeners(AuditingEntityListener.class) // ����Ǿ��� �� �ڵ����� ����Ѵ�.
public abstract class Timestamped {
    @CreatedDate // ���� ���� ����
    private LocalDateTime createdAt;

    @LastModifiedDate // ������ ���� ����
    private LocalDateTime modifiedAt;
}