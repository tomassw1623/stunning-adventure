package org.crm.crmproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.CeoMember;
import org.crm.crmproject.domain.CustomerMember;
import org.crm.crmproject.dto.CeoDTO;
import org.crm.crmproject.dto.CustomerDTO;
import org.crm.crmproject.repository.CeoMemberRepository;
import org.crm.crmproject.repository.CustomerMemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class JoinServiceImpl implements JoinService {

    private final CeoMemberRepository ceoMemberRepository;
    private final CustomerMemberRepository customerMemberRepository;

    private final ModelMapper modelMapper;

    @Override
    public void cusJoin(CustomerDTO customerDTO) throws MidExistException {

        String cid = customerDTO.getCusId();

        boolean cusExist = customerMemberRepository.existsById(cid);


        if(cusExist) {
            throw new MidExistException();
        }

        CustomerMember customerMember = modelMapper.map(customerDTO, CustomerMember.class);

        customerMemberRepository.save(customerMember);
    }

    @Override
    public void ceoJoin(CeoDTO ceoDTO) throws MidExistException {

        String ceoId = ceoDTO.getCeoId();

        boolean ceoExist = ceoMemberRepository.existsById(ceoId);

        if(ceoExist) {
            throw new MidExistException();
        }

        CeoMember ceoMember = modelMapper.map(ceoDTO, CeoMember.class);

        ceoMemberRepository.save(ceoMember);
    }
}
