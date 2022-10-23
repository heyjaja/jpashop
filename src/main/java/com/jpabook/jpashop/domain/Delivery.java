package com.jpabook.jpashop.domain;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING) // ORDINAL로 설정하면 값이 추가되거나 순서가 바뀌면 기존 값이 바뀌어 장애 발생
    private DeliveryStatus status; // READY, COMP
}
