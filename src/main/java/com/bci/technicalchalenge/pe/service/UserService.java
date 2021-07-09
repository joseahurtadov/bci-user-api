package com.bci.technicalchalenge.pe.service;

import com.bci.technicalchalenge.pe.web.model.UserRequestModel;
import com.bci.technicalchalenge.pe.web.model.UserResponseModel;

public interface UserService {

  UserResponseModel createUser(UserRequestModel userRequestModel);

}
