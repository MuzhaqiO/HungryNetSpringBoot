package com.hungerNet.Hunger.Net.repository;

import com.hungerNet.Hunger.Net.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepo extends JpaRepository<Item, UUID> {
    List<Item> getItemsByMenusMenuId(UUID menuId);
}
