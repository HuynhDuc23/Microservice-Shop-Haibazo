package com.nayzak_shop.ecommerce_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "hight_light_image", nullable = false)
    private String hightLightImage;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "view_count")
    private long viewCount;

    @Column(name = "date_end_sale")
    private LocalDateTime dateEndSale;

    @Lob
    @Column(name = "introduction")
    private String introduction;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<ProductAvailableVariant> productAvailableVariants;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CollectionProduct> collectionProducts;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<WishList> wishLists = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<>();
}
