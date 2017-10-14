package com.business;


import java.util.*;

import com.engine.io.InOutputHelper;
import com.engine.tools.*;
import com.engine.types.MonthType;

public class DateExtractor {

  private DateExtractor() {}

  public void clear()
  {
    counterByDate.clear();
  }
  /**
   * @param aFileName
   * First, read text file and collect
   * Second, pass to extract date method
   * Last, show the date and occurrence of date
   */
  public static void extractAllDateFromFile(String aFileName)
  {
    List<String> words = InOutputHelper.readTextFile(aFileName);
    extractDateMonth(words);
    showDateAndOccurrence();
  }

  /**
   * Print all
   */
  public static void showDateAndOccurrence()
  {
    counterByDate.entrySet()
        .forEach(dateOccurrence ->
            System.out.println(DateUtils.dateFormatString(dateOccurrence.getKey()) + "(" + dateOccurrence.getValue() + ")"));
  }
  /**
   * @param aWords
   * principal algorithm for extraction of date
   * here we suppose that content in text file is normal, not like mess format of date or text
   * if it isn't, we can just change the algorithm here
   */
  public static void extractDateMonth(List<String> aWords)
  {
    if (!aWords.isEmpty()) {
      int i = 0;
      while (i < aWords.size() - 1)
      {
        String word = aWords.get(i);
        /**
         * Here we suppose that format in text is dd(M)*yyyy or (M)*DDyyyy or yyyyMMdd
         * if it isn't, we just change algorithm here
         * 1. word length == 2 is when we perhaps meet day string, so we check if it is
         * If it is, there will be two situation : dd(M)*yyyy, (M)*DDyyyy
         * */
        if (word.length() == 2)
        {
          String monthOrYearWord = aWords.get(i + 1);
          if (StringUtils.isDateFormatYearString(monthOrYearWord))
          {
            i = extractFromString(monthOrYearWord, aWords.get(i - 1), word, i, 1);
          }
          else
          {
            i = extractFromString(aWords.get(i + 2), monthOrYearWord, word, i, 2);
          }
        }
        /**
         * 2. word length == 4 is when we perhaps meet year string, because we suppose here year is after 1900
         * If it is, there will be yyyyMMdd
         * */
        else if (word.length() == 4)
        {
          if (StringUtils.isDateFormatYearString(word))
          {
            i = extractFromString(word, aWords.get(i + 1), aWords.get(i + 2), i, 2);
          }
        }
        i++;
      }
    }
  }
  /**
   * @param aYearWord
   * @param aMonthWord
   * @param aDayWord
   * @param aCursor
   * @param aDisplacement
   * @return a cursor for next word
   */
  public static int extractFromString(String aYearWord, String aMonthWord, String aDayWord, int aCursor, int aDisplacement)
  {
    if (StringUtils.isDateFormatYearString(aYearWord) && StringUtils.isDateFormatDayString(aDayWord))
    {
      String monthNumberWithZero = StringUtils.getMonthNumberWithZeroByString(aMonthWord);
      if (!MonthType.NUL.getMonthWithZero().equals(monthNumberWithZero))
      {
        String dateString = StringUtils.concatenate(aYearWord, monthNumberWithZero, aDayWord);
        createAndStoreDate(dateString);
        return aCursor + aDisplacement;
      }
    }
    return aCursor;
  }
  /**
   * @param aDateString
   * Create a new date with date format we give and put in map
   */
  public static void createAndStoreDate(String aDateString)
  {
    Optional.ofNullable(DateUtils.newDateFrom(aDateString, DateUtils.yyyyMMddFormat))
        .ifPresent(date -> counterByDate.put(date, counterByDate.containsKey(date) ?
            counterByDate.get(date) + 1 : 1));
  }

  public static final Map<Date, Integer> counterByDate = new HashMap<>();
}

