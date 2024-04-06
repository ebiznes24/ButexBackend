package io.github.butexbackend.mapper;

import io.github.butexbackend.dto.ProductDTO;
import io.github.butexbackend.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO productToProductDto(Product product);

    List<ProductDTO> productListToProductDtoList(List<Product> productList);
}
