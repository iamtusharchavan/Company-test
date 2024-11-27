package com.testnimap.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testnimap.test.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
