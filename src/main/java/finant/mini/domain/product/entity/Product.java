package finant.mini.domain.product.entity;

import finant.mini.domain.bank.entity.Bank;
import finant.mini.domain.cart.entity.Cart;
import finant.mini.domain.wishlist.entity.WishList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Builder
@Slf4j
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "FIN_PRDT_NM") // 상품명
    private String productNm;

    @Column(name = "MTRT_INT") // 만기 후 이자율
    private String maturityInt;

    @Column(name = "ETC_NOTE") // 기타 유의사항
    private String etcNote;

    @Column(name = "MAX_LIMIT") // 최고한도
    private String maxLimit;

    @Column(name = "DCLS_STRT_DAY") // 공시 시작일
    private Integer disclosureStartDay;

    @Column(name = "DCLS_END_DAY") // 공시 종료일
    private String disclosureEndDay;

    @Column(name = "INTR_RATE_TYPE_NM") // 저축 금리 유형명
    private String interestRateTypeNm;

    @Column(name = "RSRV_TYPE_NM") // 적립 유형명
    private String reservesTypeNm;

    @Column(name = "SAVE_TRM") // 저축 기간(개월)
    private BigDecimal savePeriod;

    @Column(name = "INTR_RATE") // 저축 금리(소수점 2자리)
    private BigDecimal interestRate;

    @Column(name = "INTR_RATE2") // 최고 우대금리(소수점 2자리)
    private BigDecimal interestRate2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANK_ID") // 은행
    private Bank bank;

    @OneToMany(mappedBy = "product") // 관심상품
    private List<WishList> likes = new ArrayList<>();

    @OneToMany(mappedBy = "product") // 장바구니
    private List<Cart> carts = new ArrayList<>();

}
