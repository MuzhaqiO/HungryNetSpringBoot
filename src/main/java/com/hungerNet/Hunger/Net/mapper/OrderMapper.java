package com.hungerNet.Hunger.Net.mapper;

import com.hungerNet.Hunger.Net.dto.OrderDTO;
import com.hungerNet.Hunger.Net.model.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDTO toDTO (Order order);
    List<OrderDTO> toDTOs (List<Order> orders);
    Order toModel (OrderDTO orderDTO);
    List<Order> toModels (List<OrderDTO> orderDTOs);
}
