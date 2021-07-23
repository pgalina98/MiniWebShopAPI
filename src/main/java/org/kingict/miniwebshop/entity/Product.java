package org.kingict.miniwebshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
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
    private Integer kolicina;

    @ManyToMany(mappedBy = "orderProducts",
                fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Order> productOrders;
}
