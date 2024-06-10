package io.github.butexbackend.entity;

import io.github.butexbackend.model.ProductColor;
import io.github.butexbackend.model.ProductType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @Enumerated
    @ElementCollection(targetClass = ProductColor.class)
    private List<ProductColor> colors;
    private String fabric;
    private byte[] image;
}
