package org.crm.crmproject.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDTO {

    private String cusId;

    private String cusPw;

    private String cusName;

    private String cusGender;

    private String cusEmail;

    private String cusPhone;

    private LocalDate cusBirthday;

    private String cusNick;
}