package me.practice.demo.domains.login;

import me.practice.demo.domains.member.Member;

import java.util.Optional;

public interface LoginRepository {

    Optional<Member> findOne(String email, String password);

}
