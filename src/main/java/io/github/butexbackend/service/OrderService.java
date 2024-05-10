package io.github.butexbackend.service;

import io.github.butexbackend.client.FurgonetkaClient;
import io.github.butexbackend.dto.OrderDTO;
import io.github.butexbackend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final FurgonetkaClient furgonetkaClient;

    public void createOrder(OrderDTO orderDTO) {
        furgonetkaClient.validateOrderPackage(orderDTO);



    }
}
