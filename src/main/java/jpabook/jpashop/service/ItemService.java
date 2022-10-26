package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // --> 전체 적용
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;


    @Transactional // 여기만 (readOnly = false)로 적용 defalt가 false
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    /**
     *  상품 수정, 권장 코드
     */
    @Transactional //
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item findItem = itemRepository.findOne(itemId);
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

}
