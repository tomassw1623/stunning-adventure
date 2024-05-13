package org.crm.crmproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.CeoMember;
import org.crm.crmproject.dto.CeoDTO;
import org.crm.crmproject.repository.CeoMemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CeoJoinServiceImpl implements CeoJoinService{

    private final CeoMemberRepository ceoMemberRepository;
    private final ModelMapper modelMapper;

    @Override
    public void ceoJoin(CeoDTO ceoDTO) throws CusJoinService.MidExistException {

        //  id값이 null일 경우 오류 발생.. 이건 추후에 null이 아닐 경우에 처리하는 로직을 짜겠습니다.
//        Long gm = ceoDTO.getGm();
//
//        boolean ceoExist = ceoMemberRepository.existsById(gm);
//
//        if(ceoExist) {
//            throw new CusJoinService.MidExistException();
//        }

        CeoMember ceoMember = modelMapper.map(ceoDTO, CeoMember.class);

        ceoMemberRepository.save(ceoMember);
    }
}
