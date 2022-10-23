package com.jpabook.jpashop.domain;

import com.jpabook.jpashop.domain.Item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")) // 다대다 관계에서는 중간 테이블 매핑 필요
    private List<Item> items = new ArrayList<>();

    // 카테고리의 계층 구조 설정, 자신을 참조할 때
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    // 연관관계 메서드 //
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }
}
