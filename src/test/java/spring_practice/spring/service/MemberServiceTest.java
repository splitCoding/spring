package spring_practice.spring.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring_practice.spring.domain.Member;
import spring_practice.spring.repository.MemberRepository;
import spring_practice.spring.repository.MemoryMemberRepository;

public class MemberServiceTest {
    MemoryMemberRepository memberRepository;
    MemberService service;

    @BeforeEach
    public void BeforeEach() {
        memberRepository = new MemoryMemberRepository();
        service = new MemberService(memberRepository);
    }

    @AfterEach
    public void AfterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void join() {
        //given
        Member member1 = new Member();
        //when
        Long id = service.join(member1);
        //then
        assertThat(member1.getId()).isEqualTo(id);
    }

    @Test
    public void validateDuplicateMember() throws Exception {
        //given
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setName("HI");
        member2.setName("HI");
        service.join(member1);
        //when
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> service.join(member2)
        );
        //then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다");
    }
}
