package com.poly.lab7.dao;

import java.util.List;

import com.poly.lab7.entity.Product;
import com.poly.lab7.model.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductDAO extends JpaRepository<Product, Integer> {

    @Query("FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
    List<Product> findByPrice(double min, double max);

    @Query("FROM Product o WHERE o.name LIKE ?1")
    Page<Product> findByKeywords(String keyword, Pageable pageable);

    @Query("SELECT o.category AS group, SUM(o.price) AS sum, COUNT(o) AS count "
         + "FROM Product o GROUP BY o.category ORDER BY SUM(o.price) DESC")
    List<Report> getInventoryByCategory();

    List<Product> findByPriceBetween(double min, double max);

    Page<Product> findAllByNameLike(String keyword, Pageable pageable);
}
