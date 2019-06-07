package com.unrule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserLoginRepository extends
        JpaRepository<UserLogin,String>,
        JpaSpecificationExecutor<UserLogin>
{
}
