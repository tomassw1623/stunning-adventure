package org.crm.crmproject.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "customer")
public class CustomerMember  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user;

     private String cusId;

    private String cusPw;

    private String cusName;

    private String cusGender;

    private String cusEmail;

    private String cusPhone;

    private LocalDate cusBirthday;

    private String cusNick;

    public void cusChange(Long user,String cusPw, String cusName,
                       String cusGender, String cusEmail, String cusPhone, LocalDate cusBirthday, String cusNick)

    {
        this.user=user;
        this.cusPw = cusPw;
        this.cusName = cusName;
        this.cusGender = cusGender;
        this.cusEmail = cusEmail;
        this.cusPhone = cusPhone;
        this.cusBirthday = cusBirthday;
        this.cusNick = cusNick;
    }


    //이
}