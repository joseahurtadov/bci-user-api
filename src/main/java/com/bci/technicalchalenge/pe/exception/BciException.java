package com.bci.technicalchalenge.pe.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BciException extends RuntimeException {

  private HttpStatus code;

  public BciException(String message) {
    super(message);
  }

  public BciException(String message, Throwable cause) {
    super(message, cause);
  }

  public BciException(HttpStatus code, String message) {
    this(message);
    this.code = code;
  }

  public BciException(Exception cause, HttpStatus code) {
    super(cause);
    this.code = code;
  }

  public BciException(Exception cause, HttpStatus code, String message) {
    this((String) message, (Throwable) cause);
    this.code = code;
  }

}
