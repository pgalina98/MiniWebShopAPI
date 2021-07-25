package org.kingict.miniwebshop.dto;

import lombok.Data;
import org.kingict.miniwebshop.entity.Brand;

@Data
public class OrderProductDTO extends ProductDTO {

    private Integer narucenaKolicina;
}
