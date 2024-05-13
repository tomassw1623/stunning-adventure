package org.crm.crmproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.dto.CeoDTO;
import org.crm.crmproject.service.CeoJoinServiceImpl;
import org.crm.crmproject.service.CusJoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequestMapping("/ceo")
@RequiredArgsConstructor
public class CeoJoinController {

    private final CeoJoinServiceImpl ceoJoinService;
    //  사업자 회원가입
    @GetMapping("/join")
    public void ceoJoinGet(){log.info("----- join get -----");}

    @PostMapping("/join")
    public String ceoJoinPost(CeoDTO ceoDTO, RedirectAttributes redirectAttributes){

        log.info("-----ceo join post -----");
        log.info(ceoDTO);

        try {
            ceoJoinService.ceoJoin(ceoDTO);
        }catch (CusJoinService.MidExistException e){
            redirectAttributes.addFlashAttribute("error", "mg");
            return "redirect:/ceo/join";
        }

        redirectAttributes.addAttribute("result", "success");
        return "redirect:/ceo/login";
    }

    @GetMapping("/login")
    public void ceoLogin(){
        log.info("사업자로그인으로 이동");
    }

}