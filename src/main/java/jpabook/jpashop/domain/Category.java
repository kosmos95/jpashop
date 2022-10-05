package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",  //중간 테이블 메핑
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name= "item_id")
    )
    private List<Item> items = new ArrayList<>();

    // 자기자신과 매핑 하는 것이다. 이름만 내것이고 다른 Entity와 연결한 것이다. .
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id") //부모
    private Category parent;

    @OneToMany(mappedBy ="parent") //자식
    private List<Category> child = new ArrayList<>();

}


