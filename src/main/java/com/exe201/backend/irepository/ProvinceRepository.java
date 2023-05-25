package com.exe201.backend.irepository;

import com.exe201.backend.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Integer> {
    ProvinceEntity findDistinctById(int id);
}

