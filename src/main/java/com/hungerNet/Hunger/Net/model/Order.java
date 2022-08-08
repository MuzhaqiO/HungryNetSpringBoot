package com.hungerNet.Hunger.Net.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hungerNet.Hunger.Net.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "orderId")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID orderId;
    private LocalDate orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_order_id", referencedColumnName = "userId")
    private User users;

    @ManyToOne
    @JoinColumn(name = "restaurant_order_id", referencedColumnName = "restaurantId")
    private Restaurant restaurants;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "orders_items",
            joinColumns = @JoinColumn(name = "orderId"),
            inverseJoinColumns = @JoinColumn(name = "itemId"))
    private List<Item> items  = new ArrayList<>();
}
