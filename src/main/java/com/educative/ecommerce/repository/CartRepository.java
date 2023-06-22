package com.educative.ecommerce.repository;

import com.educative.ecommerce.model.Cart;
import com.educative.ecommerce.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
  List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

}