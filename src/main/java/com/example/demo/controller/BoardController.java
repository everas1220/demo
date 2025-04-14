package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@RequestMapping("/board")
@Log4j2
@Controller
public class BoardController {

    @GetMapping("/create")
    public void getCreate() {
        // return "board/create";
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
