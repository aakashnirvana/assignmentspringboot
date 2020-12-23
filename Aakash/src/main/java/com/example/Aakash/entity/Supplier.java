package com.example.Aakash.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Setter
@Getter
@Entity
@Table
public class Supplier implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String supplierId;

    @Column(name = "supplier_name")
    private String supplierName;

//    @Transient
//    @JsonIgnore
//    @OneToMany(mappedBy = "catalog")
//    private List<Catalog> catalogList;
}
