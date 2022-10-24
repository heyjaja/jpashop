package com.jpabook.jpashop.service;

import com.jpabook.jpashop.domain.Item.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ItemUpdateTest {

    @Autowired
    EntityManager em;

    @Test
    void updateTest() throws Exception {
        Book book = em.find(Book.class, 1L);

        //TX
        book.setName("update name");// jpa가 감지하여 update query를 날림

        // 변경감지 == dirty checking
        //TX commit

    }
}
