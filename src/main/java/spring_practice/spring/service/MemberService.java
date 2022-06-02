package spring_practice.spring.service;

import org.springframework.stereotype.Service;
import spring_practice.spring.domain.Member;
import spring_practice.spring.repository.MemberRepository;
import spring_practice.spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private MemoryMemberRepository repository;

    MemberService(MemoryMemberRepository repository) {
        this.repository = repository;
    }


    public Long join(Member member) {
        //���� �̸��� ������ ��� ����
        validateDuplicateMember(member);
        repository.save(member);
        return member.getId();
    }

    public Optional<Member> findOne(Long id) {
        return repository.findById(id);
    }

    public List<Member> findMembers() {
        return repository.findAll();
    }

    public void validateDuplicateMember(Member member) {
        repository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("�̹� �����ϴ� �̸��Դϴ�");
                });
    }

    public void clearRepository() {
        repository.clearStore();
    }
}
