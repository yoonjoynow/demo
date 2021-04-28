package me.practice.demo.domains.login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequestDto {

    @NotBlank
    private String email;
    @NotBlank
    private String password;

}
