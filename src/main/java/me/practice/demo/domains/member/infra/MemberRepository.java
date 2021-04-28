package me.practice.demo.domains.member.infra;

import me.practice.demo.domains.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    void save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByEmail(String email);
    List<Member> findByName(String name);
    List<Member> findAll();
    Long deleteById(Long id);

}
