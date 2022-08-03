package com.hungerNet.Hunger.Net.repository;

import com.hungerNet.Hunger.Net.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MenuRepo extends JpaRepository<Menu, UUID> {

}