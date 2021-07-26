package org.kingict.miniwebshop.controller;

import org.kingict.miniwebshop.dto.BrandDTO;
import org.kingict.miniwebshop.dto.DiscountCodeDTO;
import org.kingict.miniwebshop.facade.DiscountCodeFacade;
import org.kingict.miniwebshop.form.BrandForm;
import org.kingict.miniwebshop.form.DiscountCodeForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    @PutMapping("/{discountCodeId}")
    public ResponseEntity updateDiscountCodeById(@PathVariable("discountCodeId") Long discountCodeId,
                                                 @RequestBody DiscountCodeForm updatedDiscountCodeForm) {
        DiscountCodeDTO discountCode = discountCodeFacade.getDiscountCodeById(discountCodeId);

        if(Objects.isNull(discountCode)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(discountCodeFacade.updateDiscountCodeById(discountCodeId, updatedDiscountCodeForm),
                                  HttpStatus.OK);
    }

    //DELETE Discount Code
    @DeleteMapping("/{discountCodeId}")
    public ResponseEntity deleteDiscountCodeById(@PathVariable("discountCodeId") Long discountCodeId) {
        DiscountCodeDTO discountCode = discountCodeFacade.getDiscountCodeById(discountCodeId);

        if(Objects.isNull(discountCode)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        discountCodeFacade.deleteDiscountCodeById(discountCodeId);

        return new ResponseEntity(discountCode, HttpStatus.OK);
    }
}
