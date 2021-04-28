package me.practice.demo.domains.login;

import lombok.RequiredArgsConstructor;
import me.practice.demo.domains.member.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public boolean login(LoginRequestDto dto) {
        Optional<Member> result = loginRepository.findOne(dto.getEmail(), dto.getPassword());
        return result.isPresent();
    }

}
