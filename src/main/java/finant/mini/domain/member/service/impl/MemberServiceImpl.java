package finant.mini.domain.member.service.impl;

import finant.mini.domain.member.dto.MemberSignupReqDTO;
import finant.mini.domain.member.repository.MemberRepository;
import finant.mini.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public String memberSignup(MemberSignupReqDTO memberSignupReqDTO) {

        try {
            memberRepository.save(memberSignupReqDTO.toEntity());
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

}
