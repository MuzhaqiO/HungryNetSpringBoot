package com.hungerNet.Hunger.Net.controller;

import com.hungerNet.Hunger.Net.dto.OrderDTO;
import com.hungerNet.Hunger.Net.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("orderId/{orderId}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable UUID orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
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
}
