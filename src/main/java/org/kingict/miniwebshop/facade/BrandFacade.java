package org.kingict.miniwebshop.facade;

import org.kingict.miniwebshop.dto.BrandDTO;
import org.kingict.miniwebshop.dto.OrderDTO;
import org.kingict.miniwebshop.dto.ProductDTO;
import org.kingict.miniwebshop.form.BrandForm;
import org.kingict.miniwebshop.form.OrderForm;

import java.util.List;

public interface BrandFacade {

    BrandDTO getBrandById(Long brandId);
    List<BrandDTO> getAllBrands();
    BrandDTO createNewBrand(BrandForm brandForm);
    BrandDTO updateBrandById(Long brandId, BrandForm updatedBrand);
    void deleteBrandById(Long brandId);
    List<ProductDTO> getAllBrandProducts(Long brandId);
}
