package finant.mini.domain.cart.entity;

import finant.mini.domain.member.entity.Member;
import finant.mini.domain.product.entity.LoanProduct;
import finant.mini.domain.product.entity.Product;
import finant.mini.domain.purchase.entity.PurchaseList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Builder
@Slf4j
@Table(name = "cart") // 장바구니
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @Column(name = "apply") // 신청완료
    private String apply;

    @Column(name = "cancel") // 신청취소
    private String cancel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id") // 상품
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_product_id") // 대출상품
    private LoanProduct loanProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // 회원
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_list_id") // 구매내역
    private PurchaseList purchaseList;

}
