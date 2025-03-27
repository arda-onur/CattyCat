package com.project.cattycat.domain.user;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Address{
    private String country;
    private String city;
    private String zip;


    public Address(String country, String city, String zip) {
        this.country = country;
        this.city = city;
        this.zip = zip;
    }


}
