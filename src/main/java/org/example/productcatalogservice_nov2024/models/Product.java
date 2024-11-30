package org.example.productcatalogservice_nov2024.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private String imageUrl;
    private Double amount;

    @ManyToOne
    private Category category;
    private Boolean isPrimeSpecific;
}
