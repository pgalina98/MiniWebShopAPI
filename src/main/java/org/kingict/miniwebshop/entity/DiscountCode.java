package org.kingict.miniwebshop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "POPUST_KOD")
@Data
public class DiscountCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "KOD")
    private String kod;

    @Column(name = "POPUST")
    private Double popust;

    @Column(name = "ISKORISTEN")
    private boolean iskoristen;

    @Column(name = "DATUM_KREIRANJA")
    private LocalDateTime datumKreiranja;

    @OneToMany(mappedBy = "discountCode", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "order-discountCode")
    private List<Order> discountCodeOrders = new ArrayList<>();
}
