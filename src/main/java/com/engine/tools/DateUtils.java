package com.engine.tools;


import com.sun.media.jfxmedia.logging.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Date manipulation API
 */
public class DateUtils {
  /**
   * @param aDateString
   * @return a new date in format
   */
  public static Date newDateFrom(String aDateString, DateFormat aDateFormat)
  {
    Date date = null;
    try {
      date = aDateFormat != null ? aDateFormat.parse(aDateString) : null;
    } catch (ParseException e) {
      Logger.logMsg(Logger.ERROR, "Create Date Error");
    }
    return date;
  }
  /**
   * @param aDate
   * @return a date string of date format
   */
  public static String dateFormatString(Date aDate)
  {
    return Optional.ofNullable(aDate).map(yyyyMMddMinusFormat::format).orElse(StringUtils.Empty);
  }

  public static final DateFormat yyyyMMddFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
  public static final DateFormat ddMMMyyyyFormat = new SimpleDateFormat("ddMMMyyyy", Locale.US);
  public static final DateFormat MMMddyyyyFormat = new SimpleDateFormat("MMMddyyyy", Locale.US);
  public static final DateFormat yyyyMMddMinusFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
}
