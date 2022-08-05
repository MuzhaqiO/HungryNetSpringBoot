package com.hungerNet.Hunger.Net.dto.orderDTO;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderChangeStatusDTO {
    private UUID orderId;
    private String status;
}
