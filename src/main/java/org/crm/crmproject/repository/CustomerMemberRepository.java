package org.crm.crmproject.repository;

import org.crm.crmproject.domain.CustomerMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerMemberRepository extends JpaRepository<CustomerMember, Long> {
    Optional<CustomerMember> findByCusId(Long user);
}
