package com.nayzak_shop.ecommerce_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Entity
@Table(name = "countries")
public class Country extends BaseEntity{

    @Id
    @Column(name = "code", nullable = false)
    private long code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<State> states = new ArrayList<>();
}
