package org.example.productcatalogservice_nov2024.Controllers;

import org.example.productcatalogservice_nov2024.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getProducts() {
        return null;
    }

    @GetMapping("products/{id}")
    public Product getProductById(@PathVariable("id") long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setDescription("yet another same iphone");
        product.setAmount(130000.00);

        return product;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return null;
    }
}
