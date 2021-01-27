package com.example.testtask.repository;

import com.example.testtask.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();

    @Query(value = "SELECT COALESCE(SUM(amount), 0) FROM products WHERE name = :name", nativeQuery = true)
    Long getAmountSumByName(String name);
}
