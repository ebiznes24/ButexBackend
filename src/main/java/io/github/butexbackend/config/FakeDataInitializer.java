package io.github.butexbackend.config;

import io.github.butexbackend.entity.Product;
import io.github.butexbackend.model.ProductColor;
import io.github.butexbackend.model.ProductType;
import io.github.butexbackend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class FakeDataInitializer {

    private static final List<String> BRANDS = List.of("Nike",
            "Adidas",
            "Puma",
            "Reebok",
            "Converse",
            "New Balance",
            "Vans",
            "Under Armour",
            "Timberland");

    private static final List<String> FABRICS = List.of("Skóra naturalna",
            "Skóra syntetyczna",
            "Tekstylia",
            "Mesh",
            "Zamsz",
            "Guma",
            "Eco-skóra");

    private final ProductRepository productRepository;

    @Bean
    void initializeFakeData() {
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            products.add(Product.builder()
                    .productType(getRandomProductType())
                    .name(getRandomName())
                    .brand(getRandomBrand())
                    .price(getRandomPrice())
                    .sizes(getRandomSizes())
                    .colors(getRandomColors())
                    .fabric(getRandomFabric())
                    .build());
        }

        productRepository.saveAll(products);
    }

    private ProductType getRandomProductType() {
        Random random = new Random();
        ProductType[] values = ProductType.values();
        return values[random.nextInt(values.length)];
    }

    private String getRandomName() {
        return "Example name";
    }

    private String getRandomBrand() {
        return BRANDS.get(new Random().nextInt(BRANDS.size()));
    }

    private BigDecimal getRandomPrice() {
        return BigDecimal.valueOf(new Random().nextInt(50, 700) + 0.99);
    }

    private List<Double> getRandomSizes() {
        List<Double> sizes = new ArrayList<>();

        for (int i = 0; i < new Random().nextInt(10); i++) {
            sizes.add((double) new Random().nextInt(37, 48));
        }

        return sizes;
    }

    private List<ProductColor> getRandomColors() {
        List<ProductColor> colors = new ArrayList<>();

        Random random = new Random();
        ProductColor[] values = ProductColor.values();
        for (int i = 0; i <= new Random().nextInt(5); i++) {
            colors.add(values[random.nextInt(values.length)]);
        }

        return colors;
    }

    private String getRandomFabric() {
        return FABRICS.get(new Random().nextInt(FABRICS.size()));
    }
}
