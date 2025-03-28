package com.project.cattycat.domain.user;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Address{
    private final String country;
    private final String city;
    private final String zip;


    public Address(final String country, final String city, final String zip) {
        if(country.isBlank() || city.isBlank() ||zip.isBlank())
            throw new IllegalArgumentException("Country or City or Zip address cannot be blank");
        this.country = country;
        this.city = city;
        this.zip = zip;
    }
}
