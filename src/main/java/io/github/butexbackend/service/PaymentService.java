package io.github.butexbackend.service;

import io.github.butexbackend.client.PaynowClient;
import io.github.butexbackend.dto.paynow.PaynowBuyerDTO;
import io.github.butexbackend.dto.paynow.PaynowRequestDTO;
import io.github.butexbackend.dto.paynow.PaynowResponseDTO;
import io.github.butexbackend.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final OrderService orderService;
    private final PaynowClient paynowClient;

    public PaynowResponseDTO createPayment(Long orderId) {
        Order order = orderService.getOrder(orderId);
        PaynowRequestDTO paynowRequestDTO = buildPaynowRequest(order);

        return paynowClient.createPayment(paynowRequestDTO);
    }

    private static PaynowRequestDTO buildPaynowRequest(Order order) {
        return PaynowRequestDTO.builder()
                .amount((int) ((order.getFinalPrice() * 100)))
                .description("Opłata za zamówienie " + order.getId())
                .currency("PLN")
                .externalId(String.valueOf(order.getId()))
                .buyer(PaynowBuyerDTO.builder()
                        .email(order.getEmail())
                        .firstName(order.getName().split(" ")[0])
                        .lastName(order.getName().split(" ")[1])
                        .build())
                .build();
    }


}
