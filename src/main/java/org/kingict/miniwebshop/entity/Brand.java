package org.kingict.miniwebshop.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BRAND")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
                  property = "id",
                  scope = Brand.class)
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAZIV")
    private String naziv;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    //@JsonBackReference(value = "product-brand")
    @JsonIgnore
    private List<Product> brandProducts = new ArrayList<>();
}
