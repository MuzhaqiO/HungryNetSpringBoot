package com.hungerNet.Hunger.Net.dto;

import com.hungerNet.Hunger.Net.enums.OrderStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class OrderDTO {
    private UUID orderId;
    private OrderStatus orderStatus;
}
