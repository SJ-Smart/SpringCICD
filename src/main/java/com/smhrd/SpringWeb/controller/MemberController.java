package com.smhrd.SpringWeb.controller;

import com.smhrd.SpringWeb.dto.Cloud_Member;
import com.smhrd.SpringWeb.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    // 회원목록보기
    @GetMapping("/")
    public String main(Model model){
        List<Cloud_Member> list = service.memberList();
        model.addAttribute("list", list);
        return "main";
    }

    // 회원등록페이지 이동
    @GetMapping("/insert")
    public String insert(){
        return "insert";
    }

    // 회원등록기능
    @PostMapping("/insert")
    public String insert(Cloud_Member dto){
        service.memberInsert(dto);
        return "redirect:/";
    }

    // 회원삭제기능
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        service.memberDelete(id);
        return "redirect:/";
    }

    // 회원수정페이지 이동
    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model){
        Cloud_Member dto = service.memberSelect(id);
        model.addAttribute("dto", dto);
        return "update";
    }

    // 회원수정 기능
    @PostMapping("/update")
    public String update(Cloud_Member dto){
        service.memberUpdate(dto);
        return "redirect:/";
    }
}
