package com.jpabook.jpashop.domain.Item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A") // Item의 dtype에 들어갈 album 객체의 타입 값
@Getter @Setter
public class Album extends Item{

    private String artist;
    private String etc;
}
