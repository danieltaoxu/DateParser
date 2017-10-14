package com.test.business;

import com.business.DateExtractor;
import com.engine.tools.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.Optional;

public class DateExtractorTest {

  @Test
  public void testCreateAndStoreDate()
  {
    Date date1 =DateUtils.newDateFrom(dateString1, DateUtils.yyyyMMddFormat);
    Date date2 = DateUtils.newDateFrom(dateString2, DateUtils.yyyyMMddFormat);
    DateExtractor.counterByDate.put(date1, 1);
    DateExtractor.counterByDate.put(date2, 1);
    DateExtractor.createAndStoreDate(dateString1);
    int date1counter = Optional.ofNullable(DateExtractor.counterByDate.get(date1)).orElse(0);
    int date2counter = Optional.ofNullable(DateExtractor.counterByDate.get(date2)).orElse(0);
    Assert.assertEquals(date1counter, 2);
    Assert.assertEquals(date2counter, 1);
    Assert.assertTrue(date1counter==2);
    Assert.assertTrue(date2counter==1);
    System.out.println("Create And Store Date Successfully.");
  }

  @Test
  public void testExtractFromString()
  {
    int cursor1 = DateExtractor.extractFromString("1928", "01", "02", 1, 1);
    Assert.assertTrue(cursor1==2);
    int cursor2 = DateExtractor.extractFromString("192", "01", "02", 1, 1);
    Assert.assertFalse(cursor2==2);
  }

  protected String dateString1 = "2011-02-02";
  protected String dateString2 = "2011-02-03";
}
