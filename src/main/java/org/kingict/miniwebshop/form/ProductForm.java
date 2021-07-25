package org.kingict.miniwebshop.form;

import lombok.Data;

@Data
public class ProductForm {

    private Long brandId;

    private String naziv;

    private String opis;

    private Double cijena;

    private Integer dostupnaKolicina;
}
