package org.crm.crmproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.CeoMember;
import org.crm.crmproject.dto.CeoDTO;
import org.crm.crmproject.repository.CeoMemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class CeoJoinServiceImpl implements CeoJoinService{

    private final CeoMemberRepository ceoMemberRepository;
    private final ModelMapper modelMapper;

     @Override//
    public void ceoJoin(CeoDTO ceoDTO) throws CeoJoinService.MidExistException {

        // gm 값이 null인지 확인
        Long gm = ceoDTO.getGm();



        // CeoDTO 객체를 CeoMember 객체로 변환
        CeoMember ceoMember = modelMapper.map(ceoDTO, CeoMember.class);

        ceoMemberRepository.save(ceoMember);
    }
    public boolean login(String ceoId, String ceoPw) {
        Optional<CeoMember> ceoMemberOptional = ceoMemberRepository.findByCeoId(ceoId);
        if (ceoMemberOptional.isPresent()) {
            CeoMember ceoMember = ceoMemberOptional.get();
            return ceoMember.getCeoPw().equals(ceoPw);
        }
        return false;
    }

}

// 필드 값이 null인지 확인
//        if (ceoMember.getGm() == null || ceoMember.getCeoName() == null || gm /* other fields */) {
//            throw new IllegalArgumentException("Field values cannot be null");
//        }

// CeoMember 객체 저장