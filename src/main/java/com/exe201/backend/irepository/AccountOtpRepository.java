package com.exe201.backend.irepository;

import com.exe201.backend.entity.AccountOtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountOtpRepository extends JpaRepository<AccountOtpEntity, Integer> {
    AccountOtpEntity findOtpStateByUserId(String userId);
}