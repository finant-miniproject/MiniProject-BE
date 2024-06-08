package finant.mini.domain.wishlist.entity;

import finant.mini.domain.member.entity.Member;
import finant.mini.domain.product.entity.LoanProduct;
import finant.mini.domain.product.entity.Product;
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
@Table(name = "wishList") // 관심상품
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WISH_LIST_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID") // 회원
     private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID") // 상품
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOAN_PRODUCT_ID") // 대출 상품
    private LoanProduct loanProduct;

}

