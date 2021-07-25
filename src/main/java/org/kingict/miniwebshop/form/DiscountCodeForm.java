package org.kingict.miniwebshop.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DiscountCodeForm {

    private String kod;

    private Double popust;

    private boolean iskoristen;

    @JsonFormat(shape=JsonFormat.Shape.STRING,
            pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime datumKreiranja;
}
