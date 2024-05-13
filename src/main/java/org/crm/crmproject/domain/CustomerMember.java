package org.crm.crmproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerMember {

    @Id
    private String cusId;

    private String cusPw;

    private String cusName;

    private String cusGender;

    private String cusEmail;

    private String cusPhone;

    private LocalDate cusBirthday;

    private String cusNick;

    public void cusChange(String cusPw, String cusName,
                       String cusGender, String cusEmail, String cusPhone, LocalDate cusBirthday, String cusNick)

    {
        this.cusPw = cusPw;
        this.cusName = cusName;
        this.cusGender = cusGender;
        this.cusEmail = cusEmail;
        this.cusPhone = cusPhone;
        this.cusBirthday = cusBirthday;
        this.cusNick = cusNick;
    }
}