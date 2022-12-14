package com.hit.product.domains.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hit.product.domains.entities.base.AbstractAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product extends AbstractAuditingEntity {

    @Nationalized
    private String name;

    @Nationalized
    private String shortDescription;

    @Nationalized
    private String longDescription;

    private String slug;

    private String brand;

    @Nationalized
    private String type;

    @Nationalized
    private String gender;

    private Boolean isSale;

    private Long amountSell;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category")
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductProperties> productProperties;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<Image> images;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    @JsonIgnore
    private List<ProductRate> productRates;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    @JsonIgnore
    private List<CartItem> cartItems;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "product")
    @JsonIgnore
    private List<Voucher> vouchers;
}
