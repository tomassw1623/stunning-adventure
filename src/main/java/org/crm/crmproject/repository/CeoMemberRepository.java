package org.crm.crmproject.repository;

import org.crm.crmproject.domain.CeoMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CeoMemberRepository extends JpaRepository<CeoMember, Long> {
    Optional<CeoMember> findByCeoId(String ceoId);


}
