package com.hungerNet.Hunger.Net.model;

import com.hungerNet.Hunger.Net.enums.RoleName;
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
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "userId")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID userId;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @OneToOne
    private Restaurant restaurant;

    @OneToMany(mappedBy = "users")
    private List<Order> orders = new ArrayList<>();
}
