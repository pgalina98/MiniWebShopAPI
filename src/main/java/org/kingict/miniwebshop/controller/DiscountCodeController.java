package org.kingict.miniwebshop.controller;

import org.kingict.miniwebshop.dto.BrandDTO;
import org.kingict.miniwebshop.dto.DiscountCodeDTO;
import org.kingict.miniwebshop.facade.DiscountCodeFacade;
import org.kingict.miniwebshop.form.BrandForm;
import org.kingict.miniwebshop.form.DiscountCodeForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    public List<DiscountCodeDTO> getAllDiscountCodes() {
        return discountCodeFacade.getAllDiscountCodes();
    }

    //POST New Discount Code
    @PostMapping
    public DiscountCodeDTO createNewDiscountCode(@RequestBody DiscountCodeForm discountCodeForm) {
        return discountCodeFacade.createNewDiscountCode(discountCodeForm);
    }

    //PUT Discount Code

    //DELETE Discount Code
}
