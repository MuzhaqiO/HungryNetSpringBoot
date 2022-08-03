package com.hungerNet.Hunger.Net.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "restaurantId")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID restaurantId;
    private String restaurantName;
    private String location;

    @ManyToMany(mappedBy = "restaurants")
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "restaurants")
    private List<Menu> menus = new ArrayList<>();
}
