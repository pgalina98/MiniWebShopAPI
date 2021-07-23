package org.kingict.miniwebshop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDTO {

    //TODO -> Add Property for List of Products

    private Double ukupnaCijenaBezPopusta;

    private Double ukupnaCijenaSPopustom;

    @JsonFormat(shape=JsonFormat.Shape.STRING,
                pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime datumNarudzbe;

    private String brojKartice;

    private String email;

    private String brojMobitela;

    private String adresaDostave;

    private String napomena;
}
