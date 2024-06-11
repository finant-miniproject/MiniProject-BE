package finant.mini.domain.product.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductName {
    DEPOSIT_PRODUCT("정기예금"), SAVING_PRODUCT("적금");

    private final String desc;

}
