package com.example.Aakash.service;

import com.example.Aakash.entity.Supplier;
import com.example.Aakash.repository.SupplierReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService{
    @Autowired
    private SupplierReposiory supplierReposiory;
    @Override
    public Supplier saveSupplier(Supplier supplier) {
        Supplier supplier1 = supplierReposiory.saveAndFlush(supplier);
        System.out.println(supplier1);
        return supplier1;
    }

//    @Override
//    public List<Supplier> saveAllSupplier(List<Supplier> suppliers) {
//        return  (List<Supplier>) supplierReposiory.saveAll(suppliers);
//    }

    @Override
    public Supplier getSupplierBySupplierId(String supplierId) throws IllegalArgumentException {
        Optional<Supplier> optionalSupplier = supplierReposiory.findBySupplierId(supplierId);
        if(!optionalSupplier.isPresent())
            throw new IllegalArgumentException("Supplier Id does not exist");
        Supplier supplier = optionalSupplier.get();
        System.out.println(supplier);
        return supplier;
    }

//    @Override
//    public List<Supplier> getAllSupplier(List<String> supplierids) {
//        return  supplierReposiory.findAll();
//    }
}
