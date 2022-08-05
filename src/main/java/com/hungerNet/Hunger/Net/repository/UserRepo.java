package com.hungerNet.Hunger.Net.repository;

import com.hungerNet.Hunger.Net.enums.Roles;
import com.hungerNet.Hunger.Net.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    User getByUsername(String username);
    @Query("SELECT u FROM User u WHERE " + "u.role != com.hungerNet.Hunger.Net.enums.Roles.ADMIN")
    List<User> getUsers();

    @Query("SELECT u FROM User u WHERE " + "u.role = com.hungerNet.Hunger.Net.enums.Roles.CLIENT")
    List<User> getClientUsers();

    @Query("SELECT u FROM User u WHERE " + "u.role = com.hungerNet.Hunger.Net.enums.Roles.RESTAURANT_MANAGER")
    List<User> getManagerUsers();
}
