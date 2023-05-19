package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Getter
@Setter
public class OrderItem {
    // 얘도 Id가 필요할까?
    // 필요하다
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    // Order와 Item의 중간 테이블 이므로 두 Entity 모두와 ManyToOne으로 연관 관계를 매핑하는 모습
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private int OrderPrice; // 주문 가격
    private int count; // 주문 수량
}
