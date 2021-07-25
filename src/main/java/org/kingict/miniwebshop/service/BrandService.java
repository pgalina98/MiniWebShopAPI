package org.kingict.miniwebshop.service;

import org.kingict.miniwebshop.dto.BrandDTO;
import org.kingict.miniwebshop.entity.Brand;
import org.kingict.miniwebshop.form.BrandForm;

import java.util.List;

public interface BrandService {

    Brand getBrandById(Long brandId);
    List<Brand> getAllBrands();
    Brand createNewBrand(Brand brand);
    Brand updateBrandById(Long brandId, Brand updatedBrand);
    void deleteBrandById(Long brandId);
}
