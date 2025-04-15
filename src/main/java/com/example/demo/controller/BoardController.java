package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/board")
@Log4j2
@Controller
public class BoardController {

    @GetMapping("/create")
    public void getCreate() {
        // return "board/create";
    }

    @PostMapping("/create")
    public String postCreate(@ModelAttribute("name") String name, RedirectAttributes rttr) {
        log.info("name 값 가져오기 {}", name);

        // 어느페이지로 이동을 하던지간에 name을 유지시키고 싶다면
        // 커맨그객체, ModelAttribute(or @ModelAttribute)
        // return "redirect:/board/list";

        rttr.addAttribute("name", name);
        return "redirect:/board/list";
    }

    @GetMapping("list")
    public void getList() {
        // return "board/list";
    }

    @GetMapping("/read")
    public void getead() {
        // return "board/create";
    }

    @GetMapping("/update")
    public void getUpdate() {
        // return "board/update";
    }

    //
}
