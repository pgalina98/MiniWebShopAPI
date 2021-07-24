package org.kingict.miniwebshop.repository.implementation;

import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.repository.ProductCustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductCustomRepositoryImplementation implements ProductCustomRepository {

    private final EntityManager entityManager;

    public ProductCustomRepositoryImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> findProductsOfOrderById(Long orderId) {
        TypedQuery<Product> typedQuery = entityManager.createQuery(
            "SELECT p FROM Product p WHERE p.id = 2",
                Product.class
        );

        //typedQuery.setParameter("orderId", orderId);

        return typedQuery.getResultList();
    }
}
