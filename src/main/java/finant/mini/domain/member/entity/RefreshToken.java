package finant.mini.domain.member.entity;

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
@Table(name = "refreshToken")
public class RefreshToken {

    @Id
    @Column(name = "refresh_token_email", nullable = false)
    private String email;

    @Column(name = "refresh_token", nullable = false, columnDefinition = "text") // 토큰
    private String token;

    @OneToOne(mappedBy = "refreshToken") // 회원
    private Member member;

}
