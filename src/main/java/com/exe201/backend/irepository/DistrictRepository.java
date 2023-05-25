package com.exe201.backend.irepository;

import com.exe201.backend.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<DistrictEntity, Integer> {
    DistrictEntity findDistrictEntityByDistrictName(String districtName);

    List<DistrictEntity> findAllByProvinceId(int provinceId);

    DistrictEntity findById(int provinceId);
}
