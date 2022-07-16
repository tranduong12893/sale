package com.example.sale.entity;

import com.example.sale.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")

public class Product extends BaseEntity {
    @Id
    private String prodID;
    private String prodName;
    private BigDecimal price;
    private String description;
    private Date DateOfManf;
}
