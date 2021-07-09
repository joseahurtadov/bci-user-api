package com.bci.technicalchalenge.pe.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseModel {

  private UUID id;
  private Date created;
  private Date modified;
  private Date lastLogin;
  private String token;
  private boolean isActive;
  private ResponseModel responseModel;

}
