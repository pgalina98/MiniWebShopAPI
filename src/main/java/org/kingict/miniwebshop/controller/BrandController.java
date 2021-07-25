package org.kingict.miniwebshop.controller;

import org.kingict.miniwebshop.dto.BrandDTO;
import org.kingict.miniwebshop.facade.BrandFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandFacade brandFacade;

    public BrandController(BrandFacade brandFacade) {
        this.brandFacade = brandFacade;
    }

    //GET Single Brand
    @GetMapping("/{brandId}")
    public BrandDTO getSingleBrand(@PathVariable("brandId") Long brandId) {
        return brandFacade.getBrandById(brandId);
    }

    //GET All Brands

    //POST New Brand

    //DELETE Brand

    //GET All Brand Products
}
