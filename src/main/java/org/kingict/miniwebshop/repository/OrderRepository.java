package org.kingict.miniwebshop.repository;

import org.kingict.miniwebshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findOrderById(Long id);
}
