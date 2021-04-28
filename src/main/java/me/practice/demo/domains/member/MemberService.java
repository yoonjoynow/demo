package me.practice.demo.domains.member;

import lombok.RequiredArgsConstructor;
import me.practice.demo.domains.member.infra.JpaMemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {

    private final JpaMemberRepository memberRepository;

    /* 회원 가입 */
    public void join(SignUpRequestDto dto) {
        //중복 회원 조회
       memberRepository.findByEmail(dto.getEmail()).ifPresent(
               m -> {
                   throw new IllegalStateException("이미 존재하는 이메일입니다.");
               }
       );

       memberRepository.save(dto.toEntity());
    }

    /* 회원 조회 */
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    /* 회원 이름으로 검색 */
    public List<Member> findMemberByName(String name) {
        return memberRepository.findByName(name);
    }

    /* 회원 목록 검색 */
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    /* 회원 탈퇴 */
    public Long deleteMember(Long id) {
        return memberRepository.deleteById(id);
    }

}
