package com.g11.LanguageLearn.utils;

import java.time.LocalDate;

public class DateUtils {
  public static String getCurrentDateString() {
    return LocalDate.now().toString();
  }
  public static Long currentTimeMillis() {
    return System.currentTimeMillis();
  }
}
