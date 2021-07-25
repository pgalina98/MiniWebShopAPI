package org.kingict.miniwebshop.form;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DiscountCodeForm {

    private Long id;

    private String kod;

    private Double popust;

    private boolean iskoristen;

    private LocalDateTime datumKreiranja;
}
