package com.deepmetis.sandwichordermanagement.domain.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {

    @Id
    private String id;

    private String customerId;

    @Embedded
    private String[] ingredients;

    private float price;

    private String createdAt;

}
