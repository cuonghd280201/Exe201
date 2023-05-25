package com.exe201.backend.service;

import com.exe201.backend.entity.DistrictEntity;
import com.exe201.backend.irepository.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DistrictService {
    private final DistrictRepository districtRepository;

    public List<DistrictEntity> getAllDistrict() throws DataAccessException {
        return districtRepository.findAll();
    }

    public List<DistrictEntity> getAllDistrictByProvinceId(int provinceId) throws DataAccessException {
        return districtRepository.findAllByProvinceId(provinceId);
    }
}
