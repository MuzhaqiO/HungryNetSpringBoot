package com.hungerNet.Hunger.Net.controller;

import com.hungerNet.Hunger.Net.dto.orderDTO.OrderChangeStatusDTO;
import com.hungerNet.Hunger.Net.dto.orderDTO.OrderDTO;
import com.hungerNet.Hunger.Net.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "hunger_net/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("getAll")
    public ResponseEntity<List<OrderDTO>> findAllOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }
    @GetMapping("getCreatedOrders")
    public ResponseEntity<List<OrderDTO>> findAllCreatedOrders() {
        return ResponseEntity.ok(orderService.getCreatedOrders());
    }
    @GetMapping("getApprovedOrders")
    public ResponseEntity<List<OrderDTO>> findAllApprovedOrders() {
        return ResponseEntity.ok(orderService.getApprovedOrders());
    }
    @GetMapping("getRejectedOrders")
    public ResponseEntity<List<OrderDTO>> findAllRejectedOrders() {
        return ResponseEntity.ok(orderService.getRejectedOrders());
    }
    @GetMapping("getPreparedOrders")
    public ResponseEntity<List<OrderDTO>> findAllPreparedOrders() {
        return ResponseEntity.ok(orderService.getPreparedOrders());
    }
    @GetMapping("getWaitingOrders")
    public ResponseEntity<List<OrderDTO>> findAllWaitingOrders() {
        return ResponseEntity.ok(orderService.getWaitingOrders());
    }
    @GetMapping("getDeliveredOrders")
    public ResponseEntity<List<OrderDTO>> findAllDeliveredOrders() {
        return ResponseEntity.ok(orderService.getDeliveredOrders());
    }
    @GetMapping("orderId/{orderId}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable UUID orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
    @GetMapping("orderDate")
    public ResponseEntity<List<OrderDTO>> getOrderByDate() {
        return ResponseEntity.ok(orderService.getOrderByDate());
    }
    @GetMapping("getOrderByUser/{userId}")
    public ResponseEntity<List<OrderDTO>> getOrderByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }
    @GetMapping("getOrderByRestaurant/{restaurantId}")
    public ResponseEntity<List<OrderDTO>> getOrderByRestaurant(@PathVariable UUID restaurantId) {
        return ResponseEntity.ok(orderService.getOrdersByRestaurant(restaurantId));
    }
    @PostMapping("addNewOrder")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(orderService.addNewOrder(orderDTO));
    }
    @PutMapping("updateOrder")
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.updateOrder(orderDTO));
    }
    @DeleteMapping("delete/{orderId}")
    public void deleteOrder(@PathVariable UUID orderId) {
        orderService.deleteOrder(orderId);
    }

    @PostMapping("changeOrderStatus")
    public void changeOrderStatus(@RequestBody OrderChangeStatusDTO orderChangeStatusDTO) {
        orderService.changeStatus(orderChangeStatusDTO);
    }
}
