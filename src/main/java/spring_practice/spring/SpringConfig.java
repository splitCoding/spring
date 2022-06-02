package spring_practice.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_practice.spring.repository.MemoryMemberRepository;
import spring_practice.spring.service.MemberService;

@Configuration
public class SpringConfig {
    @Bean
    MemberService memberService() {
        return new MemberService(memoryMemberRepository());
    }

    @Bean
    MemoryMemberRepository memoryMemberRepository() {
        return new MemoryMemberRepository();
    }
}
