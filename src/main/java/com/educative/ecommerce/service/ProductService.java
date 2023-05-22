package com.educative.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educative.ecommerce.dto.product.ProductDto;
import com.educative.ecommerce.model.Category;
import com.educative.ecommerce.model.Product;
import com.educative.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public void addProduct(ProductDto productDto, Category category) {
    Product product = getProductFromDto(productDto, category);
    productRepository.save(product);
  }

  public static Product getProductFromDto(ProductDto productDto, Category category) {
    Product product = new Product();
    product.setCategory(category);
    product.setDescription(productDto.getDescription());
    product.setImageUrl(productDto.getImageUrl());
    product.setPrice(productDto.getPrice());
    product.setName(productDto.getName());
    return product;
  }

  public List<ProductDto> listProducts() {
    // first fetch all the products
    List<Product> products = productRepository.findAll();
    List<ProductDto> productDtos = new ArrayList<>();

    for (Product product : products) {
      // for each product change it to DTO
      productDtos.add(new ProductDto(product));
    }

    return productDtos;
  }

  public void updateProduct(Integer productId, ProductDto productDto, Category category) {
    Product product = getProductFromDto(productDto, category);
    // set the id for updating
    product.setId(productId);
    // update
    productRepository.save(product);
  }
}
