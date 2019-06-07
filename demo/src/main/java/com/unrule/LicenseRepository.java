package com.unrule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LicenseRepository extends
        JpaRepository<License,String>,
        JpaSpecificationExecutor<License>
{
}
