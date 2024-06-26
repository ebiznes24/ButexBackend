package io.github.butexbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private List<OrderProductDTO> products;
    private String name;
    private String street;
    private String postcode;
    private String city;
    private String email;
    private String phoneNumber;
    private String service;
    private Double finalPrice;
}
