package com.exe201.backend.irepository;

import com.exe201.backend.entity.TypeYardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeYardRepository extends JpaRepository<TypeYardEntity, Integer> {
    public TypeYardEntity getTypeYardById(int id);
}
