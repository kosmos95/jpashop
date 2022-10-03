package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;


    @ManyToOne //멤버와 다대일 관계
    @JoinColumn(name = "member_id")//member_id가 외래키가 된다
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id") // delivery_id를 외래키로 해서 사용
    private Delivery delivery;

    private LocalDateTime Date; //LocalDateTime : 자바 1.8에서 동작 자동으로 날짜 잡음

    @Enumerated(EnumType.STRING)
    private OrderStatus status ; //주문상태 [ORDER, CANCEL]

}
