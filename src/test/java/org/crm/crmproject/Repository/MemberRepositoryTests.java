package org.crm.crmproject.Repository;

import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.CustomerMember;
import org.crm.crmproject.repository.CustomerMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@Log4j2
@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    CustomerMemberRepository customerMemberRepository;

    @Test
    public void InsertMemberTests(){
        IntStream.range(0,10).forEach(i ->{
            CustomerMember customerMember = CustomerMember.builder()
                    .cusId("testCUSInsert"+i)
                    .cusEmail("test@n.com")
                    .cusName("tester"+i)
                    .cusPw("test")
                    .cusGender("men")
                    .cusPhone("010")
                    .cusBirthday(LocalDate.of(2024,1,2))
                    .build();
            CustomerMember result = customerMemberRepository.save(customerMember);
            log.info(result);
        });
    }

}
