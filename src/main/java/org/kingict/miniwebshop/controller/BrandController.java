package org.kingict.miniwebshop.controller;

import org.kingict.miniwebshop.dto.BrandDTO;
import org.kingict.miniwebshop.dto.OrderDTO;
import org.kingict.miniwebshop.dto.ProductDTO;
import org.kingict.miniwebshop.facade.BrandFacade;
import org.kingict.miniwebshop.form.BrandForm;
import org.kingict.miniwebshop.form.OrderForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    @GetMapping
    public List<BrandDTO> getAllBrands() {
        return brandFacade.getAllBrands();
    }

    //POST New Brand
    @PostMapping
    public BrandDTO createNewBrand(@RequestBody BrandForm brandForm) {
        return brandFacade.createNewBrand(brandForm);
    }

    //DELETE Brand
    @DeleteMapping("/{brandId}")
    public ResponseEntity deleteBrandById(@PathVariable("brandId") Long brandId) {
        BrandDTO brand = brandFacade.getBrandById(brandId);

        if(Objects.isNull(brand)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        brandFacade.deleteBrandById(brandId);

        return new ResponseEntity(brand, HttpStatus.OK);
    }

    //GET All Brand Products
    @GetMapping("/{brandId}/products")
    public ResponseEntity getAllBrandProducts(@PathVariable("brandId") Long brandId) {
        BrandDTO brand = brandFacade.getBrandById(brandId);

        if(Objects.isNull(brand)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(brandFacade.getAllBrandProducts(brandId), HttpStatus.OK);
    }
}
