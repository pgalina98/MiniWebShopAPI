package org.kingict.miniwebshop.service.implementation;

import org.kingict.miniwebshop.entity.Brand;
import org.kingict.miniwebshop.repository.BrandRepository;
import org.kingict.miniwebshop.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImplementation implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImplementation(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand getBrandById(Long brandId) {
        return brandRepository.findBrandById(brandId);
    }

    @Override
    public List<Brand> getAllBrands() {
        return null;
    }

    @Override
    public Brand createNewBrand(Brand brandForm) {
        return null;
    }

    @Override
    public Brand updateBrandById(Long brandId, Brand updatedBrand) {
        return null;
    }

    @Override
    public void deleteBrandById(Long brandId) {

    }
}
