package finant.mini.domain.member.service;

import finant.mini.domain.member.dto.MemberSignupReqDTO;

public interface MemberService {
    String memberSignup(MemberSignupReqDTO memberSignupReqDTO);
}
