package com.bci.technicalchalenge.pe.web;

import com.bci.technicalchalenge.pe.service.UserService;
import com.bci.technicalchalenge.pe.util.JsonUtils;
import com.bci.technicalchalenge.pe.web.model.UserRequestModel;
import com.bci.technicalchalenge.pe.web.model.UserResponseModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
@Slf4j
public class UserController {

  private UserService userService;

  @PostMapping
  public ResponseEntity<UserResponseModel> createUser(@Valid @RequestBody UserRequestModel user) {
    log.debug("request data {}", JsonUtils.objectToJSONString(user));
    return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
  }

}
