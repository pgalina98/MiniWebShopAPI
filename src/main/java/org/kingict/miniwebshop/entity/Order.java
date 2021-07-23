package org.kingict.miniwebshop.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Column(name = "DATUM")
    private LocalDateTime datumNarudzbe;

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
}
