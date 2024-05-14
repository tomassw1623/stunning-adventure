package org.crm.crmproject.domain;

import jakarta.persistence.*;
import lombok.*;
import org.crm.crmproject.dto.CeoDTO;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "ceo")

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


    //메서드 내부는 this키워드로 인스턴수 변수의 값을 파라미터로 받은 값으로 변경한다.
    //tis는 형재 객체를 가리키는 참조변수 입니다. 따라서 this.gm =gm ;는 현재 객체의 gm변수 값을 파라미터로 받은gm   값으로
    //변경하는 것을 의미합니다.
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