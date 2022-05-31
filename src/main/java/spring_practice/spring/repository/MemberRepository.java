package spring_practice.spring.repository;

import spring_practice.spring.domain.Member;

import java.util.*;

public interface MemberRepository {
    Member save(Member member); //회원 저장

    Optional<Member> findById(long id); //id로 회원 검색하여 리턴

    Optional<Member> findByName(String name); //name으로 회원 검색하여 리턴

    List<Member> findAll(); //모든 회원 리턴
}
