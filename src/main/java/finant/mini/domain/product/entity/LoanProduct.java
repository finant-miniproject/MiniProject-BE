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
    @Column(name = "loan_product_id")
    private Long id;

    @Column(name = "loan_fin_prdt_nm") // 상품명
    private String productNm;

    @Column(name = "loan_inci_expn") // 대출 부대비용
    private String incidentalExpense;

    @Column(name = "loan_erly_rpay_fee") // 중도상환 수수료
    private String earlyRepaymentFee;

    @Column(name = "loan_dly_rate") // 연체 이자율
    private String delayRate;

    @Column(name = "loan_lmt") // 대출 한도
    private String loanLimit;

    @Column(name = "LOAN_DCLS_STRT_DAY") // 공시 시작일
    private Integer disclosureStartDay;

    @Column(name = "loan_dcls_strt_day") // 공시 종료일
    private Integer disclosureEndDay;

    @Column(name = "loan_rpay_type_nm") // 대출상환유형
    private String RepaymentTypeNm;

    @Column(name = "loan_lend_rate_type_nm") // 대출금리유형
    private String InterestRateTypeNm;

    @Column(name = "loan_lend_rate_min") // 대출 금리_최저(소수점 2자리)
    private BigDecimal MinRate;

    @Column(name = "loan_lend_rate_max") // 대출금리_최고(소수점 2자리)
    private BigDecimal MaxRate;

    @Column(name = "loan_lend_rate_avg") // 전월 취급 평균금리(소수점 2자리)
    private BigDecimal RateAvg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id") // 은행
    private Bank bank;

    @OneToMany(mappedBy = "loanProduct") // 관심상품
    private List<WishList> likes = new ArrayList<>();

    @OneToMany(mappedBy = "loanProduct") // 장바구니
    private List<Cart> carts = new ArrayList<>();

}
