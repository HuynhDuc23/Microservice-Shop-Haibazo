package com.nayzak_shop.ecommerce_service.model;

import com.nayzak_shop.ecommerce_service.enums.EntityType;
import com.nayzak_shop.ecommerce_service.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Entity
@Table(name = "images")
public class Image extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "entity_id", nullable = false)
    private long entityId;

    @Enumerated(EnumType.STRING)
    @Column(name = "entity_type", nullable = false)
    private EntityType entityType;

    @Lob
    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "entity_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "entity_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Review review;

    @ManyToOne
    @JoinColumn(name = "entity_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Question question;
}
