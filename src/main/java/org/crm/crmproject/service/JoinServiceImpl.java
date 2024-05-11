package org.crm.crmproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.Member;
import org.crm.crmproject.dto.CeoDTO;
import org.crm.crmproject.dto.CustomerDTO;
import org.crm.crmproject.repository.JoinRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class JoinServiceImpl implements JoinService {

    private final JoinRepository joinRepository;

    private final ModelMapper modelMapper;

    @Override
    public void cusJoin(CustomerDTO customerDTO) throws MidExistException {

        String cid = customerDTO.getCusId();

        boolean cusExist = joinRepository.existsById(cid);


        if(cusExist) {
            throw new MidExistException();
        }

        Member member = modelMapper.map(customerDTO, Member.class);

        joinRepository.save(member);
    }

    @Override
    public void ceoJoin(CeoDTO ceoDTO) throws MidExistException {

        String ceoId = ceoDTO.getCeoId();

        boolean ceoExist = joinRepository.existsById(ceoId);

        if(ceoExist) {
            throw new MidExistException();
        }

        Member member = modelMapper.map(ceoDTO, Member.class);

        joinRepository.save(member);
    }
}
