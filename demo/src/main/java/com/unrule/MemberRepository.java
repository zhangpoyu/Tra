package com.unrule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Repository类
 *
 *
 *
 */
public interface MemberRepository extends
        JpaRepository<Member, String>,
        JpaSpecificationExecutor<Member> {

}
