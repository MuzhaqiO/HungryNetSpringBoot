package com.hungerNet.Hunger.Net.repository;

import com.hungerNet.Hunger.Net.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepo extends JpaRepository<Role, UUID> {

}
