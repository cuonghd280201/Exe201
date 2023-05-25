package com.exe201.backend.irepository;

import com.exe201.backend.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    public RoleEntity findRoleEntityById(int id);

    public RoleEntity findRoleEntityByRoleName(String roleName);

    public List<RoleEntity> findRoleEntitiesByRoleNameIn(Collection<String> roleNames);
}
