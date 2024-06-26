package finant.mini.domain.member.entity;

import finant.mini.domain.cart.entity.Cart;
import finant.mini.domain.wishlist.entity.WishList;
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
@Table(name = "member",
        uniqueConstraints = {@UniqueConstraint(name = "EMAIL_UNIQUE",
                columnNames = {"MEMBER_EMAIL"})})
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_email", nullable = false) // 이메일
    private String email;

    @Column(name = "member_name", nullable = false) // 이름
    private String name;

    @Column(name = "member_password", nullable = false) // 비밀번호
    private String password;

    @OneToMany(mappedBy = "member") // 관심상품
    private List<WishList> likes = new ArrayList<>();

    @OneToMany(mappedBy = "member") // 장바구니
    private List<Cart> carts = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refresh_token_email") // 토큰
    private RefreshToken refreshToken;
}
