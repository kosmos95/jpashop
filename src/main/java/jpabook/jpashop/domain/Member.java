package jpabook.jpashop.domain;

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

    @Embedded //내장 타입을 포함했다.
    private Address address;

    @OneToMany(mappedBy = "member") //주문과 일대다 //mappedBy -> 나는 맵핑 당한 거울이다.
    private List<Order> orders = new ArrayList<>();
}
