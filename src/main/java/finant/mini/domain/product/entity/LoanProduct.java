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
@Table(name = "loanProduct")
public class LoanProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOAN_PRODUCT_ID")
    private Long id;

    @Column(name = "LOAN_FIN_PRDT_NM") // 상품명
    private String productNm;

    @Column(name = "LOAN_INCI_EXPN") // 대출 부대비용
    private String incidentalExpense;

    @Column(name = "LOAN_ERLY_RPAY_FEE") // 중도상환 수수료
    private String earlyRepaymentFee;

    @Column(name = "LOAN_DLY_RATE") // 연체 이자율
    private String delayRate;

    @Column(name = "LOAN_LMT") // 대출 한도
    private String loanLimit;

    @Column(name = "LOAN_DCLS_STRT_DAY") // 공시 시작일
    private Integer disclosureStartDay;

    @Column(name = "LOAN_DCLS_END_DAY") // 공시 종료일
    private Integer disclosureEndDay;

    @Column(name = "LOAN_RPAY_TYPE_NM") // 대출상환유형
    private String RepaymentTypeNm;

    @Column(name = "LOAN_LEND_RATE_TYPE_NM") // 대출금리유형
    private String InterestRateTypeNm;

    @Column(name = "LOAN_RATE_MIN") // 대출 금리_최저(소수점 2자리)
    private BigDecimal MinRate;

    @Column(name = "LOAN_RATE_MAX") // 대출금리_최고(소수점 2자리)
    private BigDecimal MaxRate;

    @Column(name = "LEND_RATE_AVG") // 전원 취급 평균금리(소수점 2자리)
    private BigDecimal RateAvg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANK_ID") // 은행
    private Bank bank;

    @OneToMany(mappedBy = "loanProduct") // 관심상품
    private List<WishList> likes = new ArrayList<>();

    @OneToMany(mappedBy = "loanProduct") // 장바구니
    private List<Cart> carts = new ArrayList<>();

}
