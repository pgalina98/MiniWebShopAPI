package org.kingict.miniwebshop.service;

import org.kingict.miniwebshop.dto.BrandDTO;
import org.kingict.miniwebshop.entity.Brand;
import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.form.BrandForm;

import java.util.List;

public interface BrandService {

    Brand getBrandById(Long brandId);
    List<Brand> getAllBrands();
    Brand createNewBrand(Brand brand);
    Brand updateBrand(Brand updatedBrand);
    void deleteBrandById(Long brandId);
    List<Product> getAllBrandProducts(Long brandId);
}
