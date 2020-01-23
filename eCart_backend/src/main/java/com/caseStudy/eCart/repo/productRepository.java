package com.caseStudy.eCart.repo;

import com.caseStudy.eCart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepository extends JpaRepository<Product,Long> {
    @Override
    List<Product> findAll();

    Product findByPid(Long id);

    List<Product> findAllByPrice(Integer p);

    List<Product> findAllByPriceBetween(Integer p, Integer p2);

    List<Product> findByCategory(String s);

    List<Product> findByCategoryAndPriceBetween(String c,Integer p1,Integer p2);

    List<Product>findByName(String n);
}
