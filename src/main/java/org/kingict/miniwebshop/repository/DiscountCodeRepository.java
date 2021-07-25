package org.kingict.miniwebshop.repository;

import org.kingict.miniwebshop.entity.Brand;
import org.kingict.miniwebshop.entity.DiscountCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Long> {

    DiscountCode findDiscountCodeById(Long id);
}
