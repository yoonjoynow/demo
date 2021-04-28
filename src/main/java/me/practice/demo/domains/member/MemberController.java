package me.practice.demo.domains.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/members")
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute("member", new SignUpRequestDto());
        return "member/join";
    }

    @PostMapping
    public String join(@ModelAttribute SignUpRequestDto dto, Errors errors) {
        if (errors.hasErrors()) {
            return "redirect:/members/join";
        }

        System.out.println(dto.toString());
        memberService.join(dto);

        return "redirect:/members";
    }

    @GetMapping
    public String members(Model model) {
        model.addAttribute("members", memberService.findAllMembers());
        return "member/list";
    }

}
