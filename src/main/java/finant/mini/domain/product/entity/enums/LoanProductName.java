package finant.mini.domain.product.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoanProductName {
    MORTGAGE_LOAN_PRODUCT("주택담보대출"), RENT_HOUSE_LOAN_PRODUCT("전세자금대출");

    private final String desc;

}

