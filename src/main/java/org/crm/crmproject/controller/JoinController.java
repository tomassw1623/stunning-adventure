package org.crm.crmproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.dto.CeoDTO;
import org.crm.crmproject.dto.CustomerDTO;
import org.crm.crmproject.service.JoinService;
import org.crm.crmproject.service.JoinServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequiredArgsConstructor
public class JoinController {

    private final JoinServiceImpl joinServiceImpl;

    //  고객 회원가입
   @GetMapping("/customer/join")
    public void cusJoinGet(){log.info("----- join get -----");}

    @PostMapping("/customer/join")
    public String cusJoinPost(CustomerDTO customerDTO, RedirectAttributes redirectAttributes){

       log.info("----- join post -----");
       log.info(customerDTO);


       try {
           joinServiceImpl.cusJoin(customerDTO);
       }catch (JoinService.MidExistException e){
           redirectAttributes.addFlashAttribute("error", "cid");
           return "redirect:/customer/join";
       }

       redirectAttributes.addAttribute("result", "success");
       return "redirect:/customer/login";
    }

    //  사업자 회원가입
    @GetMapping("/ceo/join")
    public void ceoJoinGet(){log.info("----- join get -----");}

    @PostMapping("/ceo/join")
    public String ceoJoinPost(CeoDTO ceoDTO, RedirectAttributes redirectAttributes){

       log.info("----- join post -----");
       log.info(ceoDTO);

        try {
            joinServiceImpl.ceoJoin(ceoDTO);
        }catch (JoinService.MidExistException e){
            redirectAttributes.addFlashAttribute("error", "cid");
            return "redirect:/ceo/join";
        }

        redirectAttributes.addAttribute("result", "success");
        return "redirect:/customer/login";

    }

}
