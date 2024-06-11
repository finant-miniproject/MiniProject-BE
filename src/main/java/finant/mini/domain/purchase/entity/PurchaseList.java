package finant.mini.domain.purchase.entity;

import finant.mini.domain.cart.entity.Cart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Builder
@Slf4j
@Table(name = "purchaseList")
public class PurchaseList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_list_id")
    private Long id;

    @Column(name = "purchase_list_date") // 구매 날짜
    private LocalDateTime purchaseListDate;

    @Column(name = "purchaser") // 구매자
    private String purchaser;

    @Column(name = "purchase_product") // 구매 상품
    private String purchaseProduct;

    @OneToMany(mappedBy = "purchaseList") // 장바구니
    private List<Cart> carts = new ArrayList<>();

}
