package com.exe201.backend.irepository;

import com.exe201.backend.entity.YardReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YardReportRepository extends JpaRepository<YardReportEntity, String> {
    YardReportEntity findYardReportEntityById(String id);
}
