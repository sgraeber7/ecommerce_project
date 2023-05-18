package com.educative.ecommerce.model;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
// import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "category name")
  private @NotBlank String categoryName;

  private @NotBlank String description;

  private @NotBlank String imageUrl;

  // Default constructor
  public Category() {
  }

  // Constructor with categoryName and description parameters
  public Category(@NotBlank String categoryName, @NotBlank String description) {
    this.categoryName = categoryName;
    this.description = description;
  }

  // Constructor with categoryName, description, and imageUrl parameters
  public Category(@NotBlank String categoryName, @NotBlank String description,
      @NotBlank String imageUrl) {
    this.categoryName = categoryName;
    this.description = description;
    this.imageUrl = imageUrl;
  }

  // Getter for categoryName
  public String getCategoryName() {
    return this.categoryName;
  }

  // Setter for categoryName
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  // Getter for description
  public String getDescription() {
    return this.description;
  }

  // Setter for description
  public void setDescription(String description) {
    this.description = description;
  }

  // toString() method to provide a string representation of the Category object
  @Override
  public String toString() {
    return "User {category id=" + id + ", category name='" + categoryName
        + "', description='" + description + "'}";
  }

  // Getter for imageUrl
  public String getImageUrl() {
    return this.imageUrl;
  }

  // Setter for imageUrl
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  // Getter for id
  public Integer getId() {
    return this.id;
  }

  // Setter for id
  public void setId(Integer id) {
    this.id = id;
  }
}