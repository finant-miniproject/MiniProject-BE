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
    @Column(name = "wish_list_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // 회원
     private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id") // 상품
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_product_id") // 대출 상품
    private LoanProduct loanProduct;

}

