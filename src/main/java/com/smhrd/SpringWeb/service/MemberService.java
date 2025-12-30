package com.smhrd.SpringWeb.service;

import com.smhrd.SpringWeb.dto.Cloud_Member;
import com.smhrd.SpringWeb.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    // 회원 목록
    public List<Cloud_Member> memberList() {
        return repository.findAll();
    }

    // 회원 등록
    public Cloud_Member memberInsert(Cloud_Member dto) {
        // dto.id가 null이면 insert
        // dto.id가 있으면 update처럼 동작
        return repository.save(dto);
    }

    // 회원 1명 조회 (수정 페이지용)
    public Cloud_Member memberSelect(Long id) {
        return repository.findById(id).orElse(null);
    }

    // 회원 삭제
    public void memberDelete(Long id) {
        repository.deleteById(id);
    }

    // 회원 수정
    public void memberUpdate(Cloud_Member dto) {
        Cloud_Member target = repository.findById(dto.getId()).orElse(null);
        if (target == null) return;

        target.setName(dto.getName());
        target.setGender(dto.getGender());
        target.setAge(dto.getAge());

        repository.save(target);
    }
}
