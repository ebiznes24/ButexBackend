package io.github.butexbackend.mapper;

import io.github.butexbackend.dto.OrderDTO;
import io.github.butexbackend.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order orderDtoToOrder(OrderDTO orderDTO);

    OrderDTO orderToOrderDto(Order order);
}
