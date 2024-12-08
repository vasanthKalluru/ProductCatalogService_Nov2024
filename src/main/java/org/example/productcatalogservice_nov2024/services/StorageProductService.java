package org.example.productcatalogservice_nov2024.services;

import org.example.productcatalogservice_nov2024.models.Product;
import org.example.productcatalogservice_nov2024.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class StorageProductService implements IproductService{
    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isPresent()){return optionalProduct.get();}
        else
            return null;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}
