package com.enviro.assesment.grad001.jadamathele.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@Embeddable
@Getter
@Setter
public class Company {

    @Column( name = "company_name")
    private String name;
    private String catchPhrase;
    private String bs;

    public Company() {}
}
