package org.crm.crmproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CeoMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gm;

    private String ceoId;

    private String ceoPw;

    private String ceoName;

    private String ceoGender;

    private String ceoEmail;

    private String ceoPhone;

    private String ceoNum;


    public void ceoChange(Long gm,String ceoPw, String ceoName,
                       String ceoGender, String ceoEmail, String ceoPhone, String ceoNum)

    {
        this.gm = gm;
        this.ceoPw = ceoPw;
        this.ceoName = ceoName;
        this.ceoGender = ceoGender;
        this.ceoEmail = ceoEmail;
        this.ceoPhone = ceoPhone;
        this.ceoNum = ceoNum;
    }


}