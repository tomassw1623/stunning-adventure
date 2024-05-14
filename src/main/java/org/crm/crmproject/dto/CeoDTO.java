package org.crm.crmproject.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CeoDTO {

    //gm은 autoincrement
    private Long gm;

    private String ceoId;

    private String ceoPw;

    private String ceoName;

    private String ceoGender;

    private String ceoEmail;

    private String ceoPhone;

    private String ceoNum;




}