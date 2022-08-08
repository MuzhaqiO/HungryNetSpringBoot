package com.hungerNet.Hunger.Net.controller;

import com.hungerNet.Hunger.Net.dto.orderDTO.OrderChangeStatusDTO;
import com.hungerNet.Hunger.Net.dto.orderDTO.OrderDTO;
import com.hungerNet.Hunger.Net.enums.OrderStatus;
import com.hungerNet.Hunger.Net.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "hunger_net/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("getOrdersByStatus")
    public ResponseEntity<List<OrderDTO>> findOrdersByStatus(@RequestParam OrderStatus orderStatus) {
        return ResponseEntity.ok(orderService.getOrdersByStatus(orderStatus));
    }
    @PreAuthorize("hasRole('RESTAURANT_MANAGER') or hasRole('CLIENT')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @GetMapping("orderId/{orderId}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable UUID orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
    @PreAuthorize("hasRole('RESTAURANT_MANAGER') or hasRole('CLIENT')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @GetMapping("getOrderByUser/{userId}")
    public ResponseEntity<List<OrderDTO>> getOrderByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }
    @PreAuthorize("hasRole('RESTAURANT_MANAGER')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @GetMapping("getOrderByRestaurant/{restaurantId}")
    public ResponseEntity<List<OrderDTO>> getOrderByRestaurant(@PathVariable UUID restaurantId) {
        return ResponseEntity.ok(orderService.getOrdersByRestaurant(restaurantId));
    }
    @PreAuthorize("hasRole('CLIENT')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @PostMapping("addNewOrder")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(orderService.addNewOrder(orderDTO));
    }
    @PreAuthorize("hasRole('CLIENT')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @DeleteMapping("delete/{orderId}")
    public void deleteOrder(@PathVariable UUID orderId) {
        orderService.deleteOrder(orderId);
    }
    @PreAuthorize("hasRole('RESTAURANT_MANAGER')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @PostMapping("changeOrderStatus")
    public void changeOrderStatus(@RequestBody OrderChangeStatusDTO orderChangeStatusDTO) {
        orderService.changeStatus(orderChangeStatusDTO);
    }
}
