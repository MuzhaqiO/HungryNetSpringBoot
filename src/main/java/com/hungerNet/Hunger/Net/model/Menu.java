package com.hungerNet.Hunger.Net.model;

import com.hungerNet.Hunger.Net.enums.MenuNames;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "menus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "menuId")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID menuId;
    @Enumerated(EnumType.STRING)
    private MenuNames menuName;
    private Boolean menuStatus;
    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "restaurant_menu_id", referencedColumnName = "restaurantId")
    private Restaurant restaurants;

    @OneToMany(mappedBy = "menus")
    private List<Item> items = new ArrayList<>();
}
