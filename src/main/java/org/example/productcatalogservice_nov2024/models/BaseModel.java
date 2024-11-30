package org.example.productcatalogservice_nov2024.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@MappedSuperclass
public abstract class BaseModel {
    @Id
    private long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private State state;
}
