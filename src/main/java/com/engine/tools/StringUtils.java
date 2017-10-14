package com.engine.tools;

import com.engine.types.MonthType;

import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * String manipulation API
 */
public class StringUtils {

  /**
   * @param aWord
   * @return If it is a 4 length of digit String
   */
  public static boolean isDateFormatYearString(String aWord)
  {
    return Optional.ofNullable(aWord)
        .map(word -> digitYearPattern.matcher(word).matches())
        .orElse(false);
  }

  /**
   * @param aWord
   * @return If it is a 1 or 2 length of digit String
   */
  public static boolean isDateFormatDayString(String aWord)
  {
    return Optional.ofNullable(aWord)
        .map(word -> digitDayPattern.matcher(word).matches())
        .orElse(false);
  }
  /**
   * @param aFirstString
   * @param aSecondString
   * @return Concatenation of two string
   */
  public static String concatenate(String aFirstString, String aSecondString)
  {
    StringBuilder builder = new StringBuilder(Optional.ofNullable(aFirstString).orElse(Empty));
    builder.append(Optional.ofNullable(aSecondString).orElse(Empty));
    return builder.toString();
  }
  /**
   * @param aFirstString
   * @param aSecondString
   * @param aThirdString
   * @return Concatenation of three string
   */
  public static String concatenate(String aFirstString, String aSecondString, String aThirdString)
  {
    return concatenate(aFirstString, concatenate(aSecondString, aThirdString));
  }
  /**
   * @param aMonthString
   * @return If it is a month type
   */
  public static String getMonthNumberWithZeroByString(String aMonthString)
  {
    return Stream.of(MonthType.values())
        .filter(monthType -> monthType.getEnglishName().equals(aMonthString.toLowerCase()) || monthType.getShortName().equals(aMonthString.toLowerCase()) ||
            monthType.getMonthWithZero().equals(aMonthString) || String.valueOf(monthType.getIntMonthNumber()).equals(aMonthString))
        .findFirst()
        .map(MonthType::getMonthWithZero)
        .orElse(MonthType.NUL.getMonthWithZero());
  }
  /**
   *  Here we suppose the year begin with 1000
   */
  public static Pattern digitYearPattern = Pattern.compile("\\p{Digit}{4}");
  /**
   * Here we suppose the month and day String have a length of 2
   */
  public static Pattern digitDayPattern = Pattern.compile("\\p{Digit}{2}|\\p{Digit}{1}");
  /**
   * Empty string
   */
  public static String Empty = "";
}

