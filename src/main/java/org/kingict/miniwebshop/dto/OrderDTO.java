package org.kingict.miniwebshop.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class OrderDTO {

    //TODO -> Add Property for List of Products

    private Double ukupnaCijenaBezPopusta;

    private Double ukupnaCijenaSPopustom;

    private LocalDate datumNarudzbe;

    private String brojKartice;

    private String email;

    private String brojMobitela;

    private String adresaDostave;

    private String napomena;
}
