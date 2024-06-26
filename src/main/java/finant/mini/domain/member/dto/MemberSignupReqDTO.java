package finant.mini.domain.member.dto;

import finant.mini.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberSignupReqDTO {

    private Long id;
    private String email;
    private String name;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .email(email)
                .name(name)
                .password(password)
                .build();
    }
}
