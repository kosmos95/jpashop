package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") //single table이기 때문에 DB입장에서 구분할 수 있는게 필요
@Getter
@Setter
public class Book extends Item{
    private String author;
    private String isbn;
}
