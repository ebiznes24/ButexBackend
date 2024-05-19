package io.github.butexbackend.controller;

import io.github.butexbackend.dto.paynow.PaynowResponseDTO;
import io.github.butexbackend.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/payment")
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaynowResponseDTO> createPayment(@RequestParam Long orderId) {
        PaynowResponseDTO payment = paymentService.createPayment(orderId);

        if (payment == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(payment);
    }
}
