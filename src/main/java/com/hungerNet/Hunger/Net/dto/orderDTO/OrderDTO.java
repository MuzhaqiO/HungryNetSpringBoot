package com.hungerNet.Hunger.Net.dto.orderDTO;

import com.hungerNet.Hunger.Net.dto.itemDTO.ItemDTO;
import com.hungerNet.Hunger.Net.enums.OrderStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDTO {
    private UUID restaurantId;
    private UUID userId;
    private UUID orderId;
    private OrderStatus orderStatus = OrderStatus.CREATED;
    private LocalDate orderDate;
    private List<ItemDTO> items;
}
