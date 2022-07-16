package com.example.sale.entity;

import com.example.sale.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {
    @Id
    private String slNo;
    private String salesmanId;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "prodId", referencedColumnName = "prodId")
    private Product product;
    private String salesmanName;
    private String DOS;
}
