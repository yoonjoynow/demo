package me.practice.demo.domains.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@RequiredArgsConstructor
@SessionAttributes("loginMember")
@Controller
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginRequestDto", new LoginRequestDto());
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequestDto dto,
                        Model model,
                        Errors errors) {
        if (errors.hasErrors()) {
            return "redirect:/login";
        }

        boolean isLoggedIn = loginService.login(dto);
        if (isLoggedIn) {
            model.addAttribute("loginMember", dto);
            return "index";
        }

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/";
    }

}
