package org.kingict.miniwebshop.dto;

import lombok.Data;
import org.kingict.miniwebshop.entity.Brand;

@Data
public class ProductDTO {

    private Long id;

    private Brand brand;

    private String naziv;

    private String opis;

    private Double cijena;

    private Integer dostupnaKolicina;
}
