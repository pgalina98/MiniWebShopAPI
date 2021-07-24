package org.kingict.miniwebshop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BRAND")
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAZIV")
    private String naziv;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "product-brand")
    private List<Product> brandProducts = new ArrayList<>();
}
