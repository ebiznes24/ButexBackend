package io.github.butexbackend.entity;

import io.github.butexbackend.model.ProductColor;
import io.github.butexbackend.model.ProductType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ProductType productType;
    private String name;
    private String brand;
    private BigDecimal price;

    @ElementCollection
    private List<Double> sizes;
    private List<ProductColor> colors;
    private String fabric;
}
