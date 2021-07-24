package org.kingict.miniwebshop.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "NARUDZBA")
@Data
public class Order {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "POPUST_KOD_ID")
    private Long popustKodId;

    @Column(name = "NACIN_PLACANJA_ID")
    private Long nacinPlacanjaId;

    @Column(name = "UKUPNA_CIJENA_BEZ_POPUSTA")
    private Double ukupnaCijenaBezPopusta;

    @Column(name = "UKUPNA_CIJENA_S_POPUSTOM")
    private Double ukupnaCijenaSPopustom;

    @Column(name = "DATUM_KREIRANJA")
    private LocalDateTime datumKreiranjaNarudzbe;

    @Column(name = "DATUM_AZURIRANJA")
    private LocalDateTime datumAzuriranjaNarudzbe;

    @Column(name = "BROJ_KARTICE")
    private String brojKartice;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "BROJ_MOBITELA")
    private String brojMobitela;

    @Column(name = "ADRESA_DOSTAVE")
    private String adresaDostave;

    @Column(name = "NAPOMENA")
    private String napomena;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "order-orderProduct")
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "POPUST_KOD_ID", insertable = false, updatable = false)
    @JsonBackReference(value = "order-discountCode")
    private DiscountCode discountCode;

    @ManyToOne
    @JoinColumn(name = "NACIN_PLACANJA_ID", insertable = false, updatable = false)
    @JsonBackReference(value = "order-paymentMethod")
    private PaymentMethod paymentMethod;
}
