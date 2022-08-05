package com.hungerNet.Hunger.Net.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne(mappedBy = "restaurant")
    private User user;

    @OneToMany(mappedBy = "restaurants")
    private List<Menu> menus = new ArrayList<>();

    @OneToMany(mappedBy = "restaurants")
    private List<Order> orders = new ArrayList<>();
}
