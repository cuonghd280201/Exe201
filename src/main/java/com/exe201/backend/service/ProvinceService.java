package com.exe201.backend.service;

import com.exe201.backend.entity.ProvinceEntity;
import com.exe201.backend.irepository.ProvinceRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProvinceService {
    private final ProvinceRepository provinceRepository;

    public List<ProvinceEntity> getAllProvince() throws DataAccessException {
        return provinceRepository.findAll();
    }
}
