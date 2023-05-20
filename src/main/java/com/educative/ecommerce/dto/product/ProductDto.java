package com.educative.ecommerce.dto.product;

import com.educative.ecommerce.model.Product;

import jakarta.validation.constraints.NotNull;

public class ProductDto {

  private Integer id;
  private @NotNull String name;
  private @NotNull String imageUrl;
  private @NotNull double price;
  private @NotNull String description;
  private @NotNull Integer categoryId;

  public ProductDto() {
  }

  public ProductDto(@NotNull String name, @NotNull String imageUrl,
      @NotNull double price, @NotNull String description,
      @NotNull Integer categoryId) {
    this.name = name;
    this.imageUrl = imageUrl;
    this.price = price;
    this.description = description;
    this.categoryId = categoryId;
  }

  public ProductDto(Product product) {
    this.setId(product.getId());
    this.setName(product.getName());
    this.setImageUrl(product.getImageUrl());
    this.setPrice(product.getPrice());
    this.setDescription(product.getDescription());
    this.setCategoryId(product.getCategory().getId());
  }

  // Setters
  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  // Getters
  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

}
