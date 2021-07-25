package org.kingict.miniwebshop.facade.implementation;

import org.kingict.miniwebshop.dto.BrandDTO;
import org.kingict.miniwebshop.entity.Brand;
import org.kingict.miniwebshop.facade.BrandFacade;
import org.kingict.miniwebshop.form.BrandForm;
import org.kingict.miniwebshop.mapper.BrandDTOMapper;
import org.kingict.miniwebshop.service.BrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class BrandFacadeImplementation implements BrandFacade {

    private final BrandService brandService;
    private final BrandDTOMapper brandDTOMapper;

    public BrandFacadeImplementation(BrandService brandService, BrandDTOMapper brandDTOMapper) {
        this.brandService = brandService;
        this.brandDTOMapper = brandDTOMapper;
    }

    @Override
    public BrandDTO getBrandById(Long brandId) {
        return brandDTOMapper.map(brandService.getBrandById(brandId));
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        return brandDTOMapper.map(brandService.getAllBrands());
    }

    @Override
    public BrandDTO createNewBrand(BrandForm brandForm) {
        Brand brand = new Brand();

        BeanUtils.copyProperties(brandForm, brand);
        brand.setNaziv(brand.getNaziv().toUpperCase());

        return brandDTOMapper.map(brandService.createNewBrand(brand));
    }

    @Override
    public BrandDTO updateBrandById(Long brandId, BrandForm updatedBrand) {
        return null;
    }

    @Override
    public void deleteBrandById(Long brandId) {
        brandService.deleteBrandById(brandId);
    }
}
