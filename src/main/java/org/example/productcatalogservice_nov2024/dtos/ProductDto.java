package org.example.productcatalogservice_nov2024.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_nov2024.models.Category;

@Getter
@Setter

public class ProductDto {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private Double amount;
    private CategoryDto category;
}
