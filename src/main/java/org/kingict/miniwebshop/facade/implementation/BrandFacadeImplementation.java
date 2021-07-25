package org.kingict.miniwebshop.facade.implementation;

import org.kingict.miniwebshop.dto.BrandDTO;
import org.kingict.miniwebshop.dto.ProductDTO;
import org.kingict.miniwebshop.entity.Brand;
import org.kingict.miniwebshop.facade.BrandFacade;
import org.kingict.miniwebshop.form.BrandForm;
import org.kingict.miniwebshop.mapper.BrandDTOMapper;
import org.kingict.miniwebshop.mapper.ProductDTOMapper;
import org.kingict.miniwebshop.service.BrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandFacadeImplementation implements BrandFacade {

    private final BrandService brandService;
    private final BrandDTOMapper brandDTOMapper;
    private final ProductDTOMapper productDTOMapper;

    public BrandFacadeImplementation(BrandService brandService, BrandDTOMapper brandDTOMapper, ProductDTOMapper productDTOMapper) {
        this.brandService = brandService;
        this.brandDTOMapper = brandDTOMapper;
        this.productDTOMapper = productDTOMapper;
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
        Brand brand = brandService.getBrandById(brandId);

        BeanUtils.copyProperties(updatedBrand, brand);
        brand.setNaziv(brand.getNaziv().toUpperCase());

        return brandDTOMapper.map(brandService.updateBrand(brand));
    }

    @Override
    public void deleteBrandById(Long brandId) {
        brandService.deleteBrandById(brandId);
    }

    @Override
    public List<ProductDTO> getAllBrandProducts(Long brandId) {
        return productDTOMapper.map(brandService.getAllBrandProducts(brandId));
    }
}
