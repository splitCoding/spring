package spring_practice.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring_practice.spring.domain.Member;
import spring_practice.spring.repository.MemoryMemberRepository;
import spring_practice.spring.service.MemberService;

@Controller
public class MemberServiceController {
    private MemberService memberService;

    @Autowired
    MemberServiceController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String memberList(Model model) {
        model.addAttribute("members",memberService.findMembers());
        return "members/memberList";
    }

}
