package org.example.productcatalogservice_nov2024.Controllers;

import org.example.productcatalogservice_nov2024.dtos.CategoryDto;
import org.example.productcatalogservice_nov2024.dtos.ProductDto;
import org.example.productcatalogservice_nov2024.models.Product;
import org.example.productcatalogservice_nov2024.services.IproductService;
import org.example.productcatalogservice_nov2024.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ProductController {

    @Autowired // this would automatically auto wire productService to the corresponding Bean in IOC container. So an explicit constructor is not needed.
    private IproductService productService;

//    public ProductController(IproductService productService) {
//        this.productService = productService;
//    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductDto> productDtos = new ArrayList<ProductDto>();

        if(products!=null && !products.isEmpty()) {
            for(Product product : products) {
                ProductDto productDto = new ProductDto();
                productDtos.add(productDto);
            }
            return new ResponseEntity<>(productDtos, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") long productId) {
        if(productId <= 0 || productId > 20)
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

        Product product = productService.getProductById(productId);
        if (product == null) {return null;}
        return new ResponseEntity<>(from(product), HttpStatus.OK);
    }

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto product) {
        return null;
    }


    //Mapper function for ProductDto from Product
    private ProductDto from (Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setAmount(product.getAmount());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }
        return productDto;
    }



}
