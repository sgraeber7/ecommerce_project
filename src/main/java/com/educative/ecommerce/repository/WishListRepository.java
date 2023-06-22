package com.educative.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educative.ecommerce.model.User;
import com.educative.ecommerce.model.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {

  // find all the products saved to wishlist for a user
  // sort by latest created date
  List<WishList> findAllByUserOrderByCreatedDateDesc(User user);

}