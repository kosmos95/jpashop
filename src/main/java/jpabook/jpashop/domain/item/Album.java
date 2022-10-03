package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@DiscriminatorValue("A")//single table이기 때문에 DB입장에서 구분할 수 있는게 필요
@Getter
@Setter
public class Album extends Item {
    private String artist;
    private String tc;
}
