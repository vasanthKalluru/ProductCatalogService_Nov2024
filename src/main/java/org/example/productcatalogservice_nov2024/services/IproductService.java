package org.example.productcatalogservice_nov2024.services;

import org.example.productcatalogservice_nov2024.models.Product;

import java.util.List;

public interface IproductService {
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public Product createProduct(Product product);
    public Product replaceProduct(Long id,Product product);
}
