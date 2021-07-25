package org.kingict.miniwebshop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class DiscountCodeDTO {

    private Long id;

    private String kod;

    private Double popust;

    private boolean iskoristen;

    @JsonFormat(shape=JsonFormat.Shape.STRING,
            pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime datumKreiranja;
}
