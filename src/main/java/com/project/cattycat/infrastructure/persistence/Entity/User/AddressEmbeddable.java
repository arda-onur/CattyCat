package com.project.cattycat.infrastructure.persistence.Entity.User;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class AddressEmbeddable {
    private String country;
    private String city;
    private String zip;
}
