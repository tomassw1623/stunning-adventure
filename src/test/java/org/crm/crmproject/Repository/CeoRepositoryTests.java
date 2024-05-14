package org.crm.crmproject.Repository;


import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.CeoMember;
import org.crm.crmproject.dto.CeoDTO;
import org.crm.crmproject.repository.CeoMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class CeoRepositoryTests {

    @Autowired
    private  CeoMemberRepository ceoMemberRepository;

    @Test
    public void CeoMemerInsertTests(){
        IntStream.range(0,10).forEach(i ->{
               CeoMember ceoMember = CeoMember.builder()
                    .ceoId("test"+i)
                    .ceoName("testName"+i)
                    .ceoEmail("testEmail"+i)
                    .ceoNum("01001"+i)
                    .ceoPw("test")

                    .ceoGender("mail")

                    .build();
            CeoMember result  = ceoMemberRepository.save(ceoMember);
        });
    }
}
