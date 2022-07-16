package com.example.sale.seeder;

import com.example.sale.entity.Sale;
import com.example.sale.repository.ProductRepository;
import com.example.sale.repository.SaleRepository;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j

public class SaleSeeder {
    public static List<Sale> sales1;
    public static final int NUMBER_OF_SALE = 20;

    @Autowired
    SaleRepository saleRepository;
    @Autowired
    ProductRepository productRepository;
    public void generate() {
        log.debug("----------Seeding product----------");
        Faker faker = new Faker();
        sales1 = new ArrayList<>();
        for(int i = 0; i < NUMBER_OF_SALE; i++) {
            sales1.add(Sale.builder()
                    .slNo(UUID.randomUUID().toString())
                    .salesmanId(UUID.randomUUID().toString())
                    .salesmanName(faker.name().name())
                    .build());
        }
        saleRepository.saveAll(sales1)
        log.debug("---------End of seeding product-----------");
    }
}
