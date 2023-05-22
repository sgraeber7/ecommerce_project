package com.educative.ecommerce.controller;

import java.util.List;
import java.util.Optional;

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
import com.educative.ecommerce.dto.product.ProductDto;
import com.educative.ecommerce.model.Category;
import com.educative.ecommerce.service.CategoryService;
import com.educative.ecommerce.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  ProductService productService;

  @Autowired
  CategoryService categoryService;

  @PostMapping("/add")
  public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto) {
    Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
    if (!optionalCategory.isPresent()) {
      return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
    }

    Category category = optionalCategory.get();
    productService.addProduct(productDto, category);
    return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
  }

  // list all the products
  @GetMapping("/")
  public ResponseEntity<List<ProductDto>> getProducts() {
    List<ProductDto> productDtos = productService.listProducts();
    return new ResponseEntity<List<ProductDto>>(productDtos, HttpStatus.OK);
  }

  // update a product
  @GetMapping("/update/{productId}")
  public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") Integer productId,
      @RequestBody @Valid ProductDto productDto) {
    Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
    if (!optionalCategory.isPresent()) {
      return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
    }
    Category category = optionalCategory.get();
    productService.updateProduct(productId, productDto, category);
    return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
  }

}
