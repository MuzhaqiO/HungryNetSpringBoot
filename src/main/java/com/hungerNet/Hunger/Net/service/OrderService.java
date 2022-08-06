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
    public List<OrderDTO> getOrderByDate() {
        return orderMapper.toDTOs(orderRepo.findAllByOrderByOrderDate());
    }
    public List<OrderDTO> getOrders() {
        return orderMapper.toDTOs(orderRepo.findAll());
    }
    public List<OrderDTO> getCreatedOrders(){
        return orderMapper.toDTOs(orderRepo.getCreatedOrders());
    }
    public List<OrderDTO> getApprovedOrders() {
        return orderMapper.toDTOs(orderRepo.getApprovedOrders());
    }
    public List<OrderDTO> getRejectedOrders() {
        return orderMapper.toDTOs(orderRepo.getRejectedOrders());
    }
    public List<OrderDTO> getPreparedOrders() {
        return orderMapper.toDTOs(orderRepo.getPreparedOrders());
    }
    public List<OrderDTO> getWaitingOrders() {
        return orderMapper.toDTOs(orderRepo.getWaitingOrders());
    }
    public List<OrderDTO> getDeliveredOrders() {
        return orderMapper.toDTOs(orderRepo.getDeliveredOrders());
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
