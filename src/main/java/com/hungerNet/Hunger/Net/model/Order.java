package com.hungerNet.Hunger.Net.model;

import com.hungerNet.Hunger.Net.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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
//    private Order[] content;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
