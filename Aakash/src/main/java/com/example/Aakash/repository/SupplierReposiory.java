package com.example.Aakash.repository;

import com.example.Aakash.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierReposiory extends JpaRepository<Supplier, Long> {


    Optional<Supplier> findBySupplierId(String supplierId);

}
    