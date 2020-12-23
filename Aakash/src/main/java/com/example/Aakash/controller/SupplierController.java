package com.example.Aakash.controller;

import com.example.Aakash.entity.Catalog;
import com.example.Aakash.entity.Supplier;
import com.example.Aakash.service.CatalogService;
import com.example.Aakash.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/save")
    public ResponseEntity<?> saveSupplier(@RequestBody Supplier supplier) {
        ResponseEntity<?> responseEntity;
        System.out.println(supplier);
        try {
            Supplier savedSupplier = supplierService.saveSupplier(supplier);
            System.out.println("After "+supplier);
            responseEntity = new ResponseEntity<Supplier>(savedSupplier, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>("Exception occured", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }


    @GetMapping("/get/{supplierId}")
    public ResponseEntity<?> getSupplier(@PathVariable String supplierId) {
        ResponseEntity<?> responseEntity;
        try {
            Supplier getSupplier = supplierService.getSupplierBySupplierId(supplierId);
            responseEntity = new ResponseEntity<Supplier>(getSupplier, HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>("Exception Occured", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}