package com.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class JSONTool {

    public static String fromJsonp(String jsonp, String functionName) {
        String json = jsonp;
        if (jsonp != null && functionName != null) {
            String source = jsonp.trim();
            String functionStart = functionName + "(";
            String functionEnd = ")";
            if (source.startsWith(functionStart) && source.endsWith(functionEnd)) {
                json = source.substring(functionStart.length(), source.length() - 1);
            }
        }
        return json;
    }

    public static String toJson(Object target) {
        String json = null;
        if (target != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            try {
                json = objectMapper.writeValueAsString(target);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return json;
    }

    public static <T> T fromJson(String json, Class<T> target) {
        T result = null;
        if (target != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            try {
                result = objectMapper.readValue(json, target);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public static <T> T convertObject(Object object, Class<T> target) {
        if (object == null) {
            return null;
        }
        T result = null;
        if (target != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            result = objectMapper.convertValue(object, target);
        }
        return result;
    }


    public static <T> List<T> fromJsonToList(String json, Class<T> target) {
        List<T> result = null;
        if (target != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, target);
            try {
                result = objectMapper.readValue(json, javaType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
