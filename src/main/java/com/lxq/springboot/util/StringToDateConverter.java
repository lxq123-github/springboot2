package com.lxq.springboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {

  private static final String DATEFORMAT = "yyyy-MM-dd";

  @Override
  public Date convert(String value) {
    SimpleDateFormat formatter = new SimpleDateFormat(DATEFORMAT);
    try {
      return formatter.parse(value);
    } catch (Exception e) {
      throw new RuntimeException(String.format("parser %s to Date fail", value));
    }
  }
}