package finant.mini.domain.member.controller;

import finant.mini.domain.member.dto.MemberSignupReqDTO;
import finant.mini.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member/signup")
    public String signup(MemberSignupReqDTO memberSignupReqDTO) {
        return memberService.memberSignup(memberSignupReqDTO);
    }
}
