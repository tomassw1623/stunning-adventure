package org.crm.crmproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.dto.CeoDTO;
import org.crm.crmproject.service.CeoJoinService;
import org.crm.crmproject.service.CeoJoinServiceImpl;
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
    public void ceoJoinGet(){
        log.info("----- CEO 로그인페이지 접속 성공  -----");
     }



    @PostMapping("/login")
    public String ceoJoinPost(CeoDTO ceoDTO, RedirectAttributes redirectAttributes){

        log.info("-----회원가입 성공 로그인페이지로 으로 이동 -----");
        log.info(ceoDTO);

        try {
            ceoJoinService.ceoJoin(ceoDTO);
        }catch (CeoJoinService.MidExistException e){
            log.info("fail"+e.getStackTrace());
            redirectAttributes.addFlashAttribute("error", "mg");
            return "redirect:/ceo/join";

        }

        redirectAttributes.addAttribute("result", "success");
        return "redirect:/board/login";
     }


}
