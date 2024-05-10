package io.github.butexbackend.controller;

import io.github.butexbackend.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/product")
@RestController
@RequiredArgsConstructor
public class OrderController {



    @PostMapping
    public void createOrder(@RequestBody OrderDTO orderDTO){

    }
}
