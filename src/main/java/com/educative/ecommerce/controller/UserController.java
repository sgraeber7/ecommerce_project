package com.educative.ecommerce.controller;

import com.educative.ecommerce.dto.user.SignupDto;
import com.educative.ecommerce.dto.user.SignUpResponseDto;
import com.educative.ecommerce.exceptions.CustomException;
import com.educative.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping("/signup")
  public SignUpResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
    return userService.signUp(signupDto);
  }

}