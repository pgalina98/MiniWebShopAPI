package org.kingict.miniwebshop.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PROIZVOD")
@Data
public class Product {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BRAND_ID")
    private Long brandId;

    @Column(name = "NAZIV")
    private String naziv;

    @Column(name = "OPIS")
    private String opis;

    @Column(name = "CIJENA")
    private Double cijena;

    @Column(name = "KOLICINA")
    private Integer dostupnaKolicina;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    @JsonManagedReference(value = "product-orderProduct")
    private List<OrderProduct> productOrders = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", insertable = false, updatable = false)
    @JsonBackReference(value = "product-brand")
    private Brand brand;
}
