package org.kingict.miniwebshop.repository;

import org.kingict.miniwebshop.entity.Brand;
import org.kingict.miniwebshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    Brand findBrandById(Long id);
}
