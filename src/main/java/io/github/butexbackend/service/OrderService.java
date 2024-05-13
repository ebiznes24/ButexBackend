package io.github.butexbackend.service;

import io.github.butexbackend.client.FurgonetkaClient;
import io.github.butexbackend.dto.OrderDTO;
import io.github.butexbackend.dto.furgonetka.FurgonetkaPackageDTO;
import io.github.butexbackend.dto.furgonetka.FurgonetkaPackagePickupDTO;
import io.github.butexbackend.dto.furgonetka.FurgonetkaPackageReceiverDTO;
import io.github.butexbackend.dto.furgonetka.FurgonetkaPackageRequestDTO;
import io.github.butexbackend.entity.Order;
import io.github.butexbackend.mapper.OrderMapper;
import io.github.butexbackend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final FurgonetkaClient furgonetkaClient;
    private final OrderMapper orderMapper;

    public Order createOrder(OrderDTO orderDTO) {
        furgonetkaClient.validateOrderPackage(preparePackageRequestDTO(orderDTO));
        return orderRepository.save(orderMapper.orderDtoToOrder(orderDTO));
    }

    private FurgonetkaPackageRequestDTO preparePackageRequestDTO(OrderDTO orderDTO) {
        FurgonetkaPackagePickupDTO packagePickupDTO = FurgonetkaPackagePickupDTO.builder()
                .street("Przykładowa 5")
                .postcode("95-100")
                .city("Zgierz")
                .name("Jan Kowalski")
                .company("Butex Sp. z o.o.")
                .email("kontakt@butex.pl")
                .phone("353874919")
                .countryCode("PL")
                .build();

        FurgonetkaPackageReceiverDTO packageReceiverDTO = FurgonetkaPackageReceiverDTO.builder()
                .street(orderDTO.getStreet())
                .postcode(orderDTO.getPostcode())
                .city(orderDTO.getCity())
                .name(orderDTO.getName())
                .company("")
                .email(orderDTO.getEmail())
                .phone(orderDTO.getPhoneNumber())
                .countryCode("PL")
                .build();

        List<FurgonetkaPackageDTO> furgonetkaPackageDTOList = new ArrayList<>();

        orderDTO.getProducts().forEach(orderProductDTO -> {
            for (int i = 0; i < orderProductDTO.getQuantity(); i++) {
                FurgonetkaPackageDTO packageDTO = FurgonetkaPackageDTO.builder()
                        .width(30)
                        .depth(50)
                        .height(20)
                        .weight(0.5f)
                        .description("Buty")
                        .build();
                furgonetkaPackageDTOList.add(packageDTO);
            }
        });

        return FurgonetkaPackageRequestDTO.builder()
                .service_id(orderDTO.getService().id)
                .pickup(packagePickupDTO)
                .receiver(packageReceiverDTO)
                .parcels(furgonetkaPackageDTOList)
                .type("package")
                .build();
    }
}
