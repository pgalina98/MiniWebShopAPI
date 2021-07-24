package org.kingict.miniwebshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "NARUDZBA_PROIZVOD")
@Data
public class OrderProduct {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NARUDZBA_ID")
    private Long narudzbaId;

    @Column(name = "PROIZVOD_ID")
    private Long proizvodId;

    @Column(name = "KOLICINA")
    private Integer kolicina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NARUDZBA_ID", insertable = false, updatable = false)
    @JsonBackReference(value = "order-orderProduct")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROIZVOD_ID", insertable = false, updatable = false)
    @JsonBackReference(value = "product-orderProduct")
    private Product product;
}
