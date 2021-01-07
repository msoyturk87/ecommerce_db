package com.cybertek.model;

import com.cybertek.enums.ProductCondition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity<Long>{

    private String name;

    @Column(columnDefinition = "text")
    private String description;

    private BigDecimal price;

    private Integer quantity;

    private BigDecimal volume;

    private BigDecimal weight;

    @Enumerated(EnumType.STRING)
    private ProductCondition productCondition;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "uom_id")
    private Uom uom;

    @ManyToMany
    @JoinTable(name = "product_sub_category_rel",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "sub_category_id"))
    private List<SubCategory> subCategories; // talk about this part for Set

    @ManyToMany
    @JoinTable(name = "product_attribute_value_rel",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_value_id"))
    private List<AttributeValue> attributeValues;
}
