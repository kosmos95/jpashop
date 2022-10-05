package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;


    @ManyToOne(fetch = LAZY) //멤버와 다대일 관계
    @JoinColumn(name = "member_id")//member_id가 외래키가 된다
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)// persist를 전파한다.
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id") // delivery_id를 외래키로 해서 사용
    private Delivery delivery;

    private LocalDateTime Date; //LocalDateTime : 자바 1.8에서 동작 자동으로 날짜 잡음

    @Enumerated(EnumType.STRING)
    private OrderStatus status ; //주문상태 [ORDER, CANCEL]

}
