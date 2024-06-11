package finant.mini.domain.bank.entity;

import finant.mini.domain.product.entity.LoanProduct;
import finant.mini.domain.product.entity.Product;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Builder
@Slf4j
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id")
    private Long id;

    @Column(name = "bank_name", nullable = false) // 은행명
    private String name;

    @Column(name = "icon_path", columnDefinition = "text") // 은행로고
    private String imgPath;

    @OneToMany(mappedBy = "bank") // 상품
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "bank") // 관심상품
    private List<LoanProduct> loanProducts = new ArrayList<>();
}