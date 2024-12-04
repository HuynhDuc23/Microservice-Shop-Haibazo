package com.nayzak_shop.ecommerce_service.model;

import com.nayzak_shop.ecommerce_service.enums.Collections;
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
@Table(name = "collections")
public class Collection extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "collection_type")
    private Collections collectionType;

    @Lob
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL)
    private List<CollectionProduct> collectionProducts = new ArrayList<>();
}
