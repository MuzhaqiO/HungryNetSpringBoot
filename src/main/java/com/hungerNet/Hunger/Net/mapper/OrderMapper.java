package com.hungerNet.Hunger.Net.mapper;

import com.hungerNet.Hunger.Net.dto.orderDTO.OrderDTO;
import com.hungerNet.Hunger.Net.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "restaurants.restaurantId", target = "restaurantId")
    @Mapping(source = "users.userId", target = "userId")
    OrderDTO toDTO (Order order);
    List<OrderDTO> toDTOs (List<Order> orders);
    @Mapping(source = "restaurantId", target = "restaurants.restaurantId")
    @Mapping(source = "userId", target = "users.userId")
    Order toModel (OrderDTO orderDTO);
    List<Order> toModels (List<OrderDTO> orderDTOs);
}
