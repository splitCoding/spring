package spring_practice.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring_practice.spring.repository.MemoryMemberRepository;
import spring_practice.spring.service.MemberService;

@Controller
public class MemberServiceController {
    private MemberService memberService;
    @Autowired
    MemberServiceController(MemberService memberService) {
        this.memberService = memberService;
    }

}
