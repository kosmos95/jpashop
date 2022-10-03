package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column (name= "delivery_id" )
    private Long id;

    @OneToOne(mappedBy ="delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // ORDINAL은 숫자로 들어가는데 중간에 상태가 들어가면 밀려버린다.
    private DeliveryStatus status; // READY - 배송준비, COMP - 배송중


}
