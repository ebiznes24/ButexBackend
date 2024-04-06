package io.github.butexbackend.service;

import io.github.butexbackend.dto.ProductDTO;
import io.github.butexbackend.mapper.ProductMapper;
import io.github.butexbackend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDTO> getAllProducts() {
        return productMapper.productListToProductDtoList(productRepository.findAll());
    }

    public ProductDTO getProduct(Long id) {
        return productRepository.findById(id).map(productMapper::productToProductDto).orElse(null);
    }
}
