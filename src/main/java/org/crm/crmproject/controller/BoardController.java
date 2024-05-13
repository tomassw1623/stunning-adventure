package org.crm.crmproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/list")
    public void goBoard(){
        log.info("------------list에 접속-------------");

    }

    @GetMapping("/login")
    public void goLogin(){
        log.info("로그인페이지로 이동");
    }
}
