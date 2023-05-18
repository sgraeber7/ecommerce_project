package com.educative.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educative.ecommerce.model.Category;
import com.educative.ecommerce.repository.CategoryRepository;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public Category readCategory(String categoryName) {
    return categoryRepository.findByCategoryName(categoryName);
  }

  public void createCategory(Category category) {
    categoryRepository.save(category);
  }

}
