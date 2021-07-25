package org.kingict.miniwebshop.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "NACIN_PLACANJA")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
                  property = "id",
                  scope = PaymentMethod.class)
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAZIV")
    private String naziv;

    @OneToMany(mappedBy = "paymentMethod", fetch = FetchType.LAZY)
    //@JsonBackReference(value = "order-paymentMethod")
    @JsonIgnore
    private List<Order> paymentMethodOrders = new ArrayList<>();
}
