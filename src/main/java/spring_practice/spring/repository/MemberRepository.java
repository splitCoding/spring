package spring_practice.spring.repository;

import spring_practice.spring.domain.Member;

import java.util.*;

public interface MemberRepository {
    Member save(Member member); //ȸ�� ����

    Optional<Member> findById(long id); //id�� ȸ�� �˻��Ͽ� ����

    Optional<Member> findByName(String name); //name���� ȸ�� �˻��Ͽ� ����

    List<Member> findAll(); //��� ȸ�� ����
}
