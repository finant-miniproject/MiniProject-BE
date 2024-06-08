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
    @Column(name = "CART_ID")
    private Long id;

    @Column(name = "APPLY") // 신청완료
    private String apply;

    @Column(name = "CANCEL") // 신청취소
    private String cancel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID") // 상품
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOAN_PRODUCT_ID") // 대출상품
    private LoanProduct loanProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID") // 회원
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PURCHASE_LIST_ID") // 구매내역
    private PurchaseList purchaseList;

}
