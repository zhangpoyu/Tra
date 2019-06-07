package com.unrule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UnruleRequestRepository extends
        JpaRepository<UnruleRequest,String>,
        JpaSpecificationExecutor<UnruleRequest>
{
}
