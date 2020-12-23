package com.example.Aakash.service;

import com.example.Aakash.entity.Catalog;
import com.example.Aakash.entity.Supplier;
import com.example.Aakash.repository.CatalogRepository;
import com.example.Aakash.repository.SupplierReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;
    @Autowired
    private SupplierReposiory supplierReposiory;

    @Override
    public Catalog saveCatalog(Catalog catalog) {
        System.out.println("Inside Service"+catalog);

        Supplier exitingSupplier = supplierReposiory.findBySupplierId(catalog.getSupplier().getSupplierId()).get();
        if(exitingSupplier.getSupplierId() == null){
            System.out.println("Supplier not exist... Saving Sup");
            exitingSupplier = supplierReposiory.saveAndFlush(catalog.getSupplier());
            System.out.println("Supplier not exist... Saving Sup "+exitingSupplier);
        }
        catalog.setSupplier(exitingSupplier);
        System.out.println("exitingSupplier "+exitingSupplier);
        Catalog cat = catalogRepository.saveAndFlush(catalog);
        System.out.println("cat  cat"+cat);
        return cat;
    }

    @Override
    public List<Catalog> saveAllCatalog(List<Catalog> Catalogs) {
        return (List<Catalog>) catalogRepository.saveAll(Catalogs);
    }

    @Override
    public Catalog getCatalog(String skuCode) throws IllegalArgumentException {
        Optional<Catalog> optionalCatalog = catalogRepository.findBySkuCode(skuCode);
        System.out.println("Inside getCatalogService with " +optionalCatalog.get());
        if (!optionalCatalog.isPresent())
            throw new IllegalArgumentException("Catalog does not exist");
        Catalog cat = optionalCatalog.get();
        return cat;
    }

    @Override
    public List<Catalog> getAllCatalog() {
        return catalogRepository.findAll();
    }

    @Override
    public List<String> getSkuCodeBYSupplierId(String supplierId, String matching) {
        List<String> skuCodeOfProduct=catalogRepository.getSkuName(supplierId,matching);

        return  skuCodeOfProduct;
    }


}
