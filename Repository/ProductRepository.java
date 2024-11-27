package com.testnimap.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testnimap.test.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
