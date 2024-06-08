package finant.mini.domain.cart.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum CartProductName {

    PRODUCT("상품"), LOAN_PRODUCT("대출상품");

    private final String desc;

}
