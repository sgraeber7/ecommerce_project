package com.educative.ecommerce.controller;

import java.util.Objects;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educative.ecommerce.common.ApiResponse;
import com.educative.ecommerce.model.Category;
import com.educative.ecommerce.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @PostMapping("/create")
  public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
    if (Objects.nonNull(categoryService.readCategory(category.getCategoryName()))) {
      return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category already exists"), HttpStatus.CONFLICT);
    }
    categoryService.createCategory(category);
    return new ResponseEntity<ApiResponse>(new ApiResponse(true, "created the category"), HttpStatus.CREATED);
  }

  @GetMapping("/")
  public ResponseEntity<List<Category>> getCategories() {
    List<Category> body = categoryService.listCategories();
    return new ResponseEntity<List<Category>>(body, HttpStatus.OK);
  }

  @PostMapping("/update/{categoryId}")
  public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") Integer categoryId,
      @Valid @RequestBody Category category) {
    // Check to see if the category exists
    if (Objects.nonNull(categoryService.readCategory(categoryId))) {
      // if the category already exists then update it
      categoryService.updateCategory(categoryId, category);
      return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the category"), HttpStatus.OK);
    }

    // if the category doesn't exist then return a response of unsuccessful
    return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
  }

}
