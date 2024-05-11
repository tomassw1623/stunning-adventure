package org.crm.crmproject.repository;

import org.crm.crmproject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JoinRepository extends JpaRepository<Member, String> {

    Optional<Member> findJoinByCusId(String cusId);

    Optional<Member> findJoinByCeoId(String ceoId);
}