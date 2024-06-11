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
    @Column(name = "product_id")
    private Long id;

    @Column(name = "fin_prdt_nm") // 상품명
    private String productNm;

    @Column(name = "mtrt_int") // 만기 후 이자율
    private String maturityInt;

    @Column(name = "etc_note") // 기타 유의사항
    private String etcNote;

    @Column(name = "max_limit") // 최고한도
    private String maxLimit;

    @Column(name = "dcls_strt_day") // 공시 시작일
    private Integer disclosureStartDay;

    @Column(name = "dcls_end_day") // 공시 종료일
    private String disclosureEndDay;

    @Column(name = "intr_rate_type_nm") // 저축 금리 유형명
    private String interestRateTypeNm;

    @Column(name = "rsrv_type_nm") // 적립 유형명
    private String reservesTypeNm;

    @Column(name = "save_trm") // 저축 기간(개월)
    private BigDecimal savePeriod;

    @Column(name = "intr_rate") // 저축 금리(소수점 2자리)
    private BigDecimal interestRate;

    @Column(name = "intr_rate2") // 최고 우대금리(소수점 2자리)
    private BigDecimal interestRate2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id") // 은행
    private Bank bank;

    @OneToMany(mappedBy = "product") // 관심상품
    private List<WishList> likes = new ArrayList<>();

    @OneToMany(mappedBy = "product") // 장바구니
    private List<Cart> carts = new ArrayList<>();

}
