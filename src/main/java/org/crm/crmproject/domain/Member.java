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
public class Member {

    @Id
    private String id;

    private String userId;

    private String pw;

    private String name;

    private String gender;

    private String email;

    private String phone;

    private LocalDate birth;

    private String nick;
}