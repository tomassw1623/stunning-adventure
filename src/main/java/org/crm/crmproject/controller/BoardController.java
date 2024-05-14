package org.crm.crmproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.service.CeoJoinServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

    private final CeoJoinServiceImpl ceoJoinServiceIpl;


    @GetMapping("/list")
    public void goBoard(){
        log.info("------------list에 접속-------------");

    }

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String ceoId, @RequestParam String ceoPw, RedirectAttributes redirectAttributes) {
        boolean loginSuccess = ceoJoinServiceIpl.login(ceoId, ceoPw);
        if (loginSuccess) {
            redirectAttributes.addAttribute("result", "success");
            log.info("asdasd");
            return "redirect:/MyPage";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid ID or password");
            log.info("실패"+redirectAttributes);
            return "redirect:/join";
        }
    }


}
