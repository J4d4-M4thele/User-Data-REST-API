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
public class Geo {

    private String lat;
    private String lng;

    public Geo() {}
}
