package com.hungerNet.Hunger.Net.service;

import com.hungerNet.Hunger.Net.dto.orderDTO.OrderChangeStatusDTO;
import com.hungerNet.Hunger.Net.dto.orderDTO.OrderDTO;
import com.hungerNet.Hunger.Net.enums.OrderStatus;
import com.hungerNet.Hunger.Net.mapper.OrderMapper;
import com.hungerNet.Hunger.Net.model.Order;
import com.hungerNet.Hunger.Net.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public List<OrderDTO> getOrdersByStatus(OrderStatus orderStatus){return orderMapper.toDTOs(orderRepo.getCreatedOrderStatus(orderStatus));}
    public OrderDTO addNewOrder(OrderDTO orderDTO){
        Order createdOrder = orderMapper.toModel(orderDTO);
        createdOrder.setOrderStatus(OrderStatus.CREATED);
        createdOrder.setOrderDate(LocalDate.now());
        orderRepo.save(createdOrder);
        return orderMapper.toDTO(createdOrder);
    }
    public void deleteOrder(UUID orderId) {
        orderRepo.deleteById(orderId);
    }

    public void changeStatus (OrderChangeStatusDTO orderChangeStatusDTO){
        Order order = orderRepo.getReferenceById(orderChangeStatusDTO.getOrderId());
        order.setOrderStatus(OrderStatus.valueOf(orderChangeStatusDTO.getStatus()));
        orderRepo.save(order);
    }

    public List<OrderDTO> getOrdersByUser(UUID userId) {
        return orderMapper.toDTOs(orderRepo.getOrdersByUser(userId));
    }
    public List<OrderDTO> getOrdersByRestaurant(UUID restaurantId) {
        return orderMapper.toDTOs(orderRepo.getOrdersByRestaurant(restaurantId));
    }
}
