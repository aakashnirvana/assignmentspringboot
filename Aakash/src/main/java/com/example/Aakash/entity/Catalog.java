package com.example.Aakash.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Catalog implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long Id;

    @Column(name = "sku_code", unique = true)
    private String skuCode;

    @Column(name = "sku_name")
    private String skuName;

    @Column(name = "sku_description")
    private String skuDescription;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "brand_description")
    private String brandDescription;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier")
    private Supplier supplier;
}
