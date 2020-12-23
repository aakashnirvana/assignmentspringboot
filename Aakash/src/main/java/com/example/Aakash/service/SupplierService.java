package com.example.Aakash.service;

import com.example.Aakash.entity.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {
    Supplier saveSupplier(Supplier supplier);

//   List <Supplier> saveAllSupplier(List<Supplier> suppliers);

    Supplier getSupplierBySupplierId(String supplierId) throws IllegalArgumentException;

//    List<Supplier> getAllSupplier(List<String> supplierids);
}
