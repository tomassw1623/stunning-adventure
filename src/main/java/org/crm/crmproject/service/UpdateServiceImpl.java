//package org.crm.crmproject.service;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.crm.crmproject.domain.CeoMember;
//import org.crm.crmproject.domain.CustomerMember;
//import org.crm.crmproject.dto.CeoDTO;
//import org.crm.crmproject.dto.CustomerDTO;
//import org.crm.crmproject.repository.CeoMemberRepository;
//import org.crm.crmproject.repository.CustomerMemberRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@Log4j2
//@RequiredArgsConstructor
//public class UpdateServiceImpl implements UpdateService {
//
//        private final CustomerMemberRepository customerMemberRepository;
//        private final CeoMemberRepository ceoMemberRepository;
//
//        private final ModelMapper modelMapper;
//
//        @Override
//        public void ceoUpdate(CeoDTO ceoDTO) {
//            Optional<CeoMember> result = ceoMemberRepository.findById(ceoDTO.getGm());
//
//            CeoMember ceomember = result.orElseThrow();
//
//            ceomember.ceoChange(ceomember.getGm(), ceoDTO.getCeoPw(), ceoDTO.getCeoName(), ceoDTO.getCeoGender(),
//                    ceoDTO.getCeoEmail(), ceoDTO.getCeoPhone(), ceoDTO.getCeoNum());
//
//            ceoMemberRepository.save(ceomember);
//        }
//        @Override
//        public void cusUpdate(CustomerDTO customerDTO) {
//        Optional<CustomerMember> result = customerMemberRepository.findById(customerDTO.getUser());
//
//        CustomerMember member = result.orElseThrow();
//
//        member.cusChange(customerDTO.getUser(), customerDTO.getCusPw(), customerDTO.getCusName(),customerDTO.getCusGender(),
//                customerDTO.getCusEmail(), customerDTO.getCusPhone(), customerDTO.getCusBirthday(), customerDTO.getCusNick());
//
//            customerMemberRepository.save(member);
//    }
//        @Override
//        public CeoDTO readOne(Long gm) {
//
//            Optional<CeoMember> result =  ceoMemberRepository.findById(gm);
//
//            CeoMember ceoMember = result.orElseThrow();
//
//            CeoDTO ceoDTO = modelMapper.map(ceoMember, CeoDTO.class);
//
//            return ceoDTO;
//        }
//        @Override
//        public CustomerDTO readOne2(Long user) {
//
//            Optional<CustomerMember> result =  customerMemberRepository.findById(user);
//
//            CustomerMember customerMember = result.orElseThrow();
//
//            CustomerDTO customerDTO = modelMapper.map(customerMember, CustomerDTO.class);
//
//            return customerDTO;
//        }
//
//}
