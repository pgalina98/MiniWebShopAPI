package org.kingict.miniwebshop.repository;

import org.kingict.miniwebshop.dto.OrderProductDTO;
import org.kingict.miniwebshop.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

    List<OrderProduct> findAllByNarudzbaId(Long orderId);
    OrderProduct findByNarudzbaIdAndProizvodId(Long orderId, Long productId);
}
