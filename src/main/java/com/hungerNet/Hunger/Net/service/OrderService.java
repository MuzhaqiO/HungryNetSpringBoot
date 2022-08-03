package com.hungerNet.Hunger.Net.service;

import com.hungerNet.Hunger.Net.dto.OrderDTO;
import com.hungerNet.Hunger.Net.mapper.OrderMapper;
import com.hungerNet.Hunger.Net.model.Order;
import com.hungerNet.Hunger.Net.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    private final OrderMapper orderMapper;

    public OrderDTO getOrderById(UUID orderId) {
        return orderMapper.toDTO(orderRepo.getReferenceById(orderId));
    }
    public List<OrderDTO> getOrders() {
        return orderMapper.toDTOs(orderRepo.findAll());
    }
    public OrderDTO addNewOrder(OrderDTO orderDTO){
        Order createdOrder = orderRepo.save(orderMapper.toModel(orderDTO));
        return orderMapper.toDTO(createdOrder);
    }
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toModel(orderDTO);
        orderRepo.save(order);
        return orderMapper.toDTO(order);
    }
    public void deleteOrder(UUID orderId) {
        orderRepo.deleteById(orderId);
    }
}
