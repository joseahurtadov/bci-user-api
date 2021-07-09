package com.bci.technicalchalenge.pe.service.impl;

import com.bci.technicalchalenge.pe.entity.Phones;
import com.bci.technicalchalenge.pe.entity.Users;
import com.bci.technicalchalenge.pe.exception.BciException;
import com.bci.technicalchalenge.pe.repository.PhonesRepository;
import com.bci.technicalchalenge.pe.repository.UsersRepository;
import com.bci.technicalchalenge.pe.service.UserService;
import com.bci.technicalchalenge.pe.thirdparty.external.pubsub.PubSubSenderService;
import com.bci.technicalchalenge.pe.thirdparty.external.pubsub.dto.UserDTO;
import com.bci.technicalchalenge.pe.util.JWTUtil;
import com.bci.technicalchalenge.pe.util.JsonUtils;
import com.bci.technicalchalenge.pe.web.model.PhoneRequestModel;
import com.bci.technicalchalenge.pe.web.model.ResponseModel;
import com.bci.technicalchalenge.pe.web.model.UserRequestModel;
import com.bci.technicalchalenge.pe.web.model.UserResponseModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UsersRepository usersRepository;
  private final PhonesRepository phonesRepository;
  private final PubSubSenderService pubSubSenderService;

  @Override
  public UserResponseModel createUser(UserRequestModel user) {
    if (usersRepository.findByEmail(user.getEmail()).isPresent()) {
      throw new BciException(HttpStatus.CONFLICT, "El correo ya fue registrado");
    }

    Users users = usersRepository.save(buildUser(user));
    user.getPhones().forEach(phone -> savePhones(phone, users.getId()));

    pubSubSenderService.sendMessageToGCPPubSub(
        JsonUtils.objectToJSONString(UserDTO.builder()
            .name(users.getName())
            .email(users.getEmail())
            .build()));

    return UserResponseModel.builder()
        .id(users.getId())
        .created(users.getDateCreated())
        .token(users.getToken())
        .isActive(users.isActive())
        .responseModel(ResponseModel.builder()
            .message("El usuario se creo exitosamente")
            .code(HttpStatus.CREATED)
            .build())
        .build();
  }

  private Users buildUser(UserRequestModel user) {
    return Users.builder()
        .name(user.getName())
        .email(user.getEmail())
        .password(user.getPassword())
        .dateCreated(new Date())
        .token(JWTUtil.createJWT(
            UUID.randomUUID().toString(),
            user.getName(),
            user.getEmail(),
            new Date().getTime()))
        .isActive(true)
        .build();
  }

  private void savePhones(PhoneRequestModel phone, UUID id) {
    phonesRepository.save(Phones.builder()
        .userId(id)
        .number(phone.getNumber())
        .cityCode(phone.getCityCode())
        .countryCode(phone.getCountryCode())
        .build());
  }

}
