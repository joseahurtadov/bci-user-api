package com.bci.technicalchalenge.pe.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestModel {

  @NotBlank(message = "El nombre no puede ser vacio")
  private String name;
  @Email(message = "Debe ingresar un correo valido")
  @NotBlank(message = "El correo no puede estar vacio")
  private String email;
  @NotBlank(message = "La contraseña no puede ser vacio")
  @Pattern(regexp = "^(?=.*?\\d.*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$",
      message = "La contraseña debe tener al menos una letra mayúscula, una letra minúscula y dos números, además la longitud debe estar entre 8 y 16")
  private String password;
  @NotEmpty(message = "Los teléfonos deben tener al menos un valor")
  @Valid
  private List<PhoneRequestModel> phones;

}
