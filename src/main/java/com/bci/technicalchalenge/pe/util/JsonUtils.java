package com.bci.technicalchalenge.pe.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public final class JsonUtils {
  private JsonUtils() {
  }

  public static <T> String objectToJSONString(T data) {
    ObjectMapper mapper = new ObjectMapper();

    try {
      return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
    } catch (JsonProcessingException var3) {
      throw new RuntimeException(var3);
    }
  }

  public static <T> T stringToObject(String jsonString, Class<T> clazz) {
    return stringToObject(jsonString, (String) null, clazz);
  }

  @SuppressWarnings("unchecked")
  public static <T> T stringToObject(String jsonString, String fieldName, Class<T> clazz) {
    Object object = null;

    try {
      if (jsonString != null && !jsonString.trim().equals("")) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = null;
        actualObj = mapper.readTree(jsonString);
        if (fieldName != null && !fieldName.equals("")) {
          actualObj = actualObj.get(fieldName);
        }

        object = mapper.treeToValue(actualObj, clazz);
      }

      return (T) object;
    } catch (IOException var6) {
      throw new RuntimeException(var6);
    }
  }
}
