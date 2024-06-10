package io.github.butexbackend.dto;

import io.github.butexbackend.model.ProductColor;
import io.github.butexbackend.model.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {

    private Long id;
    private ProductType productType;
    private String name;
    private String brand;
    private BigDecimal price;
    private List<Double> sizes;
    private List<ProductColor> colors;
    private String fabric;
    private byte[] image;
}
