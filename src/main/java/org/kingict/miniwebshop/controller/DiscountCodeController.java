package org.kingict.miniwebshop.controller;

import org.kingict.miniwebshop.dto.DiscountCodeDTO;
import org.kingict.miniwebshop.facade.DiscountCodeFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeFacade discountCodeFacade;

    public DiscountCodeController(DiscountCodeFacade discountCodeFacade) {
        this.discountCodeFacade = discountCodeFacade;
    }

    //GET Single Discount Code
    @GetMapping("/{discountCodeId}")
    public DiscountCodeDTO getSingleDiscountCode(@PathVariable("discountCodeId") Long discountCodeId) {
        return discountCodeFacade.getDiscountCodeById(discountCodeId);
    }

    //GET All Discount Codes

    //POST New Discount Code

    //PUT Discount Code
}
