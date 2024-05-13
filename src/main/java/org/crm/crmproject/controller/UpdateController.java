package org.crm.crmproject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.dto.CeoDTO;
import org.crm.crmproject.dto.CustomerDTO;
import org.crm.crmproject.service.UpdateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequiredArgsConstructor
public class UpdateController {
    private final UpdateService updateService;
//    @PreAuthorize("isAuthenticated()")  // 인증된 사용자만 접근 가능...

    @GetMapping({"/read","/ceo/update"})  //조회
    public void CeoRead(Long gm, Model model) {
        CeoDTO ceoDTO = updateService.readOne(gm);
        log.info(ceoDTO);
        model.addAttribute("dto", ceoDTO);
    }

    @GetMapping("/ceo/update")
    public void ceoUpdateGet(){log.info("----- update get -----");}

    @PostMapping("/ceo/reLogin")
    public String ceoUpdatePost(@Valid CeoDTO ceoDTO, RedirectAttributes redirectAttributes) {
        log.info("ceo modify post ...... " + ceoDTO);

        try {
            updateService.ceoUpdate(ceoDTO);
        }catch (UpdateService.MidExistException e){
            redirectAttributes.addFlashAttribute("error", "cid");
            return "redirect:/ceo/update";
        }
        redirectAttributes.addAttribute("result", "success");
        return "redirect:/ceo/login";
    }

    //    @PreAuthorize("isAuthenticated()")  // 인증된 사용자만 접근 가능...
    @GetMapping({"/read","/customer/update"})  //조회
    public void cusRead(Long user, Model model) {
        CustomerDTO customerDTO = updateService.readOne2(user);
        log.info(customerDTO);
        model.addAttribute("dto", customerDTO);
    }

    @GetMapping("/customer/update")
    public void cusUpdateGet(){log.info("----- update get -----");}


    @PostMapping("/customer/reLogin")
    public String cusUpdatePost(@Valid CustomerDTO customerDTO, RedirectAttributes redirectAttributes) {
        log.info("customer modify post ...... " + customerDTO);

        try {
            updateService.cusUpdate(customerDTO);
        }catch (UpdateService.MidExistException e){
            redirectAttributes.addFlashAttribute("error", "user");
            return "redirect:/customer/update";
        }
        redirectAttributes.addAttribute("result", "success");
        return "redirect:/customer/login";
    }
}
