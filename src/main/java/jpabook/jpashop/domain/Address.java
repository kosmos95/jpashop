package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable // 자바 jap 내장가능 한것 뭔지 잘 모르겠다.
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
