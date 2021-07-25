package org.kingict.miniwebshop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.kingict.miniwebshop.entity.DiscountCode;
import org.kingict.miniwebshop.entity.PaymentMethod;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {

    private Long id;

    private DiscountCode discountCode;

    private PaymentMethod paymentMethod;

    private List<OrderProductDTO> orderProducts;

    private Double ukupnaCijenaBezPopusta;

    private Double ukupnaCijenaSPopustom;

    @JsonFormat(shape=JsonFormat.Shape.STRING,
            pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime datumKreiranjaNarudzbe;

    @JsonFormat(shape=JsonFormat.Shape.STRING,
            pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime datumAzuriranjaNarudzbe;

    private String brojKartice;

    private String email;

    private String brojMobitela;

    private String adresaDostave;

    private String napomena;
}
