package com.educative.ecommerce.repository;

import com.educative.ecommerce.model.Category;
import com.educative.ecommerce.repository.CategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

  Category findByCategoryName(String categoryName);

}
