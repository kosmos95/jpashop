package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable // 자바 jap 내장가능 한것 뭔지 잘 모르겠다.
@Getter //값 타입은 기본적으로 변경이 되면 안된다. 생성할 때만 값이 셋팅 되어야 한다.

public class Address { //기본 생성자를 만들어 줘야한다.
    private String city;
    private String street;
    private String zipcode;

    protected Address() {
        //jpa 스펙상 만들어둔 것이다.
        //public은 다른 곳에서 호출 할수 있으니 protected까지는 허용해준다.
    }
    public Address (String city, String street, String zipcode) {
        this.city =city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
