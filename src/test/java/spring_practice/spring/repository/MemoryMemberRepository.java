package spring_practice.spring.repository;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spring_practice.spring.domain.Member;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        //member 생성
        Member member1 = new Member();
        member1.setName("member1");

        //member 저장
        repository.save(member1);

        //member 조회
        Member result = repository.findByName("member1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findByName() {
        //member1, member2 생성, 저장
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);

        //member1, member2 조회
        Member result1 = repository.findByName("member1").get();
        Member result2 = repository.findByName("member2").get();

        assertThat(result1).isEqualTo(member1);
        assertThat(result2).isEqualTo(member2);
    }

    @Test
    public void findAll(){
        //member1, member2 생성, 저장
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);

        //총 member의 숫자가 2가 맞는지 테스트
        assertThat(repository.findAll().size()).isEqualTo(2);

    }
}
