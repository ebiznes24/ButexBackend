package io.github.butexbackend.controller;

import io.github.butexbackend.dto.OrderDTO;
import io.github.butexbackend.entity.Order;
import io.github.butexbackend.mapper.OrderMapper;
import io.github.butexbackend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/order")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        Order order = orderService.validateOrderAndSaveEntity(orderDTO);
        return ResponseEntity.ok(orderMapper.orderToOrderDto(order));
    }
}
