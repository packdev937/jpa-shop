package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    // 기능을 살펴보면 회원 조회, 회원 가입
    // 회원 가입 할 때 중복 검사를 해야지
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public void validateDuplicateMember(Member member) {
        // 같은 이름이 이미 있으면 에러인거잖아
        if (memberRepository.findByName(member.getName()).size() > 0)
            throw new IllegalStateException("이미 존재하는 회원입니다.");
    }
}
