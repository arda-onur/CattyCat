package com.project.cattycat.infrastructure.persistence.Entity.User;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressEmbeddable {
    private String street;
    private String city;
    private String zipCode;
}
