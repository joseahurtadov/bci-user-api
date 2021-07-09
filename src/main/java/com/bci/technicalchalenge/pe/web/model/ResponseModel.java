package com.bci.technicalchalenge.pe.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
@JsonIgnoreProperties(
    ignoreUnknown = true
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel {

  private HttpStatus code;
  private String message;

}
