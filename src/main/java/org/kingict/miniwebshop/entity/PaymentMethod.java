package org.kingict.miniwebshop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "NACIN_PLACANJA")
@Data
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAZIV")
    private String naziv;

    @OneToMany(mappedBy = "paymentMethod", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "order-paymentMethod")
    private List<Order> paymentMethodOrders = new ArrayList<>();
}
