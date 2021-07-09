package com.bci.technicalchalenge.pe.web.exception;

import com.bci.technicalchalenge.pe.exception.BciException;
import com.bci.technicalchalenge.pe.web.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@RestControllerAdvice
public class BciExceptionHandler {

  @ExceptionHandler({BciException.class})
  @ResponseBody
  public ResponseEntity<ResponseModel> handleJobDescriptionException(BciException exception) {
    return new ResponseEntity(ResponseModel.builder()
        .code(exception.getCode())
        .message(exception.getMessage())
        .build(), exception.getCode());
  }

  @ExceptionHandler(value = {
      ConstraintViolationException.class
  })
  public ResponseEntity<ResponseModel> handleResourceNotFoundException(ConstraintViolationException e) {
    Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
    StringBuilder strBuilder = new StringBuilder();
    for (ConstraintViolation violation : violations) {
      strBuilder.append(violation.getMessage() + "\n");
    }
    return new ResponseEntity(ResponseModel.builder()
        .code(HttpStatus.BAD_REQUEST)
        .message(strBuilder.toString())
        .build(), HttpStatus.BAD_REQUEST);
  }

}
