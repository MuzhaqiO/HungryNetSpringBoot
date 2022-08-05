package com.hungerNet.Hunger.Net.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "itemId")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID itemId;
    private String itemName;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "menu_item_id", referencedColumnName = "menuId")
    private Menu menus;

    @ManyToMany(mappedBy = "items")
    private List<Order> orders = new ArrayList<>();
}
