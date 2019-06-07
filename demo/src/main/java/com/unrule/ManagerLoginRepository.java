package com.unrule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ManagerLoginRepository extends
        JpaRepository<ManagerLogin,String>,
        JpaSpecificationExecutor<ManagerLogin>
{
}
