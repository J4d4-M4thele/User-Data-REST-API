package com.enviro.assesment.grad001.jadamathele.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Data
@AllArgsConstructor
@Embeddable
@Getter
@Setter
public class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;

    @Embedded
    private Geo geo;

    public Address() {}
}
