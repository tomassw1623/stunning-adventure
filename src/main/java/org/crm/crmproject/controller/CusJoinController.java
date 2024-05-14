package org.crm.crmproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.CustomerMember;
import org.crm.crmproject.dto.CustomerDTO;
import org.crm.crmproject.repository.CeoMemberRepository;
import org.crm.crmproject.repository.CustomerMemberRepository;
import org.crm.crmproject.service.CusJoinService;
import org.crm.crmproject.service.CusJoinServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CusJoinController {

    private final CusJoinServiceImpl cusJoinServiceImpl;
    private final CustomerMemberRepository customerMemberRepository;

    //  고객 회원가입
    @GetMapping("/join")
    public void cusJoinGet(){log.info("----- join get -----");}

//    @PostMapping("/login")
//    public String cusJoinPost(CustomerDTO customerDTO, RedirectAttributes redirectAttributes){
//
//       log.info("----- join post -----");
//       log.info(customerDTO);
//
//
//       try {
//           cusJoinServiceImpl.cusJoin(customerDTO);
//       }catch (CusJoinService.MidExistException e){
//           redirectAttributes.addFlashAttribute("error", "user");
//           return "redirect:/customer/join";
//       }
//
//       redirectAttributes.addAttribute("result", "success");
//       return "redirect:/board/login";      //리다이렉트 경로 customer에서 board로 임시 변경했습니다.
//    }

    @PostMapping("/login")
    public String registerCustomer(@ModelAttribute CustomerDTO customerDTO) {
        CustomerMember customerMember = CustomerMember.builder()
                .cusId(customerDTO.getCusId())
                .cusPw(customerDTO.getCusPw())
                .cusName(customerDTO.getCusName())
                .cusGender(customerDTO.getCusGender())
                .cusEmail(customerDTO.getCusEmail())
                .cusPhone(customerDTO.getCusPhone())
                .cusBirthday(customerDTO.getCusBirthday())
                .cusNick(customerDTO.getCusNick())
                .build();

        customerMemberRepository.save(customerMember);
log.info(customerMemberRepository);
log.info(customerMember);
        return "redirect:/";
    }






}
