package com.bci.technicalchalenge.pe.exception;

import com.google.api.gax.rpc.StatusCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PubSubIntercorpException extends RuntimeException {

  private StatusCode statusCode;
  private boolean retry;

  public PubSubIntercorpException(String message) {
    super(message);
  }

  public PubSubIntercorpException(StatusCode statusCode,
                                  boolean retry,
                                  Throwable cause) {
    super(cause);
    this.statusCode = statusCode;
    this.retry = retry;
  }
}
