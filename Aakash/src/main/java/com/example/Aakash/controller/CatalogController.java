package com.example.Aakash.controller;

import com.example.Aakash.entity.Catalog;
import com.example.Aakash.service.CatalogService;
//import com.example.Aakash.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

//    @Autowired
//    private SupplierService supplierService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCatalog(@RequestBody Catalog catalogs) {
        ResponseEntity<?> responseEntity;
        System.out.println(catalogs);
        try {
            Catalog savedCatalog = catalogService.saveCatalog(catalogs);
            System.out.println("After "+catalogs);
            responseEntity = new ResponseEntity<Catalog>(savedCatalog, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>("Exception occured", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getSkuCode(@PathVariable String id) {
        ResponseEntity<?> responseEntity;
        try {
            Catalog savedcatalog = catalogService.getCatalog(id);
            responseEntity = new ResponseEntity<Catalog>(savedcatalog, HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>("Exception Occured", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
//
//    @PostMapping("/saveall")
//    public ResponseEntity<?> saveAllCatalog(@RequestBody List<Catalog> Catalogs) {
//        ResponseEntity responseEntity;
//        try {
//            List<Catalog> savedcatalog = catalogService.saveAllCatalog(Catalogs);
//            responseEntity = new ResponseEntity<List<Catalog>>(savedcatalog, HttpStatus.OK);
//        } catch (Exception ndfe) {
//            responseEntity = new ResponseEntity<String>("Exception occured", HttpStatus.BAD_REQUEST);
//        }
//
//        return responseEntity;
//    }
//
//    @GetMapping("/getall")
//    public ResponseEntity<?> getAllStudent() {
//        ResponseEntity<?> responseEntity;
//        try {
//            List<Catalog> savedCatalog = catalogService.getAllCatalog();
//            responseEntity = new ResponseEntity<>(savedCatalog, HttpStatus.OK);
//        } catch (Exception e) {
//            responseEntity = new ResponseEntity<String>("Exception Occured", HttpStatus.BAD_REQUEST);
//        }
//        return responseEntity;
//
//    }
//
//    @GetMapping("/supplier/get/{id}")
//    public ResponseEntity<?> getSupplier(@PathVariable String id) {
//        ResponseEntity<?> responseEntity;
//        try {
//            Optional<Supplier> savedsupplier = supplierService.getSupplier(id);
//            responseEntity = new ResponseEntity<Optional<Supplier>>(savedsupplier, HttpStatus.OK);
//        } catch (Exception ex) {
//            responseEntity = new ResponseEntity<String>("Exception Occured", HttpStatus.BAD_REQUEST);
//        }
//        return responseEntity;
//    }
//
//    @PostMapping("/supplier/save")
//    public ResponseEntity<?> savesupplier(@RequestBody Supplier suppliers) {
//        ResponseEntity<?> responseEntity;
//        try {
//            Supplier savedSupplier = supplierService.saveSupplier(suppliers);
//            responseEntity = new ResponseEntity<Supplier>(savedSupplier, HttpStatus.OK);
//        } catch (Exception e) {
//            responseEntity = new ResponseEntity<String>("Exception occured", HttpStatus.BAD_REQUEST);
//        }
//        return responseEntity;
//    }
//@GetMapping("/getskuname")
//    public ResponseEntity<?> getSkuName(@RequestBody String supplierId,String matching){
//        ResponseEntity<?> responseEntity;
//        try{
//            List<String> skuName=catalogRepository.getSkuName(supplierId,matching);
//            responseEntity =new ResponseEntity<List<String>>(skuName,HttpStatus.OK);
//        }catch(Exception e){
//            responseEntity=new ResponseEntity<String>("Exception Occurred",HttpStatus.BAD_REQUEST);
//
//        }
//        return responseEntity;
//    }

    @GetMapping("/getproduct/")
    public ResponseEntity<?> getSkuCodeBySupplierId(@RequestParam String supplierId,@RequestParam String matching) {
        ResponseEntity<?> responseEntity;
        try {

            List<String> skuCodeOfProducts=catalogService.getSkuCodeBYSupplierId(supplierId,matching);
                    responseEntity = new ResponseEntity<List<String>>(skuCodeOfProducts, HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>("Exception Occured", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}