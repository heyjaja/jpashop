package com.jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded //내장타입 명시
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "member") // 연관관계의 거울, member 필드에 의해 매핑 된다.
    private List<Order> orders = new ArrayList<>();
}
