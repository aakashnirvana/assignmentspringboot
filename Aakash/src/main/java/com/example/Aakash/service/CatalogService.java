package com.example.Aakash.service;

import com.example.Aakash.entity.Catalog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatalogService {
    Catalog saveCatalog(Catalog catalog);

    List<Catalog> saveAllCatalog(List<Catalog> Catalogs);

    Catalog getCatalog(String skuCode) throws IllegalArgumentException;

    List<Catalog> getAllCatalog();

   List<String> getSkuCodeBYSupplierId(String supplierId, String matching);
}
