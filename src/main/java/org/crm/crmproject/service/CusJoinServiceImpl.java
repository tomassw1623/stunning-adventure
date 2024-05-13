package org.crm.crmproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.CustomerMember;
import org.crm.crmproject.dto.CustomerDTO;
import org.crm.crmproject.repository.CeoMemberRepository;
import org.crm.crmproject.repository.CustomerMemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class CusJoinServiceImpl implements CusJoinService {

    private final CustomerMemberRepository customerMemberRepository;

    private final ModelMapper modelMapper;

    @Override
    public void cusJoin(CustomerDTO customerDTO) throws MidExistException {

        Long user = customerDTO.getUser();

        boolean cusExist = customerMemberRepository.existsById(user);


        if(cusExist) {
            throw new MidExistException();
        }

        CustomerMember customerMember = modelMapper.map(customerDTO, CustomerMember.class);

        customerMemberRepository.save(customerMember);
    }


}
