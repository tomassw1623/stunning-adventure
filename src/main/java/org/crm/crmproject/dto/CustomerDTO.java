package org.crm.crmproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Setter;
import org.crm.crmproject.domain.CustomerMember;
import org.crm.crmproject.service.CeoJoinService;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data


public class CustomerDTO {
    //user는 AutoIncrement
    private Long user;

    private String cusId;

    private String cusPw;

    private String cusName;

    private String cusGender;

    private String cusEmail;

    private String cusPhone;

    private String cusNick;

    //@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "Asia/Seoul")
   // private LocalDate cusBirthday;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate cusBirthday;


    public CustomerMember toEntity() {
        return CustomerMember.builder()
                .user(this.getUser())
                .cusId(this.getCusId())
                .cusPw(this.getCusPw())
                .cusName(this.getCusName())
                .cusGender(this.getCusGender())
                .cusEmail(this.getCusEmail())
                .cusPhone(this.getCusPhone())
                .cusBirthday(this.getCusBirthday())
                .cusNick(this.getCusNick())
                .build();
    }

}