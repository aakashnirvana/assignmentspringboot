package com.example.Aakash.repository;

import com.example.Aakash.entity.Catalog;
import com.example.Aakash.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {

    //    @Query("SELECT s FROM CATALOG s where s.sku_code= :skuCode")
    Optional<Catalog> findBySkuCode(String skuCode);

    @Query("SELECT s.sku_name FROM catalog s where s.supplier=?1 and s.sku_name LIKE %?2%")
    List<String> getSkuName(String supplierId, String matching);


}

