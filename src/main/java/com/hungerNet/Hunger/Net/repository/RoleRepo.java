package com.hungerNet.Hunger.Net.repository;

import com.hungerNet.Hunger.Net.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoleRepo extends JpaRepository<Role, UUID> {

    @Query(value = "SELECT * FROM roles WHERE roleName IN (:roleNames)", nativeQuery = true)
    Role findAllByName(String roleName);
    Role getRoleByRoleName(String roleNames);
}
