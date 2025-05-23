package com.example.demo.controller;

import java.lang.reflect.Member;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/member")
@Controller
public class MemberController {
    // 회원가입 : /member/register
    // 로그인 : /member/login
    // 로그아웃 : /member/logout
    // 비밀번호변경 : /member/change

    // http://localhost:8080/member/register
    // void : templates/member/register.html
    @GetMapping("/register")
    public void getRegister(@ModelAttribute("mDTO") MemberDTO memberDTO) {
        log.info("회원가입");
    }

    @PostMapping("/register")
    public String postRehister(@ModelAttribute("mDTO") @Valid MemberDTO memberDTO, BindingResult result,
            RedirectAttributes rttr) {
        log.info("회원가입 요청 {}", memberDTO);

        if (result.hasErrors()) {
            return "/member/register";
        }
        // 로그인 페이지로 이동
        // redirect 방식으로 가면서 값을 보내고 싶다면? model(X)
        rttr.addAttribute("userid", memberDTO.getUserid());
        // /member/login?userid=1
        rttr.addFlashAttribute("password", memberDTO.getPassword());
        return "redirect:/member/login";

    }

    @GetMapping("/login")
    public void getLogin() {
        log.info("로그인 페이지 요청");
    }

    @PostMapping("/login")
    public void postLogin(HttpServletRequest request) {
        // HttpServletRequest : 사용자의 정보 및 서버 쪽의 정보 추출
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String remote = request.getRemoteAddr();
        String local = request.getRemoteAddr();

        log.info("로그인 요청 {} {}", userid, password);
        log.info("클라이언트 정보 {} {}", remote, local);
    }

    @GetMapping("/logout")
    public void getLogout() {
        log.info("로그아웃");
    }

    @GetMapping("/change")
    public void getChange() {
        log.info("비밀번호변경");
    }

}
