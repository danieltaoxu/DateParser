package com.test.engine;

import com.engine.tools.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class DateUtilsTest {
  @Test
  public void testNewDateFrom()
  {
    Date date = DateUtils.newDateFrom(dateString, null);
    Assert.assertTrue(null == date);
    date = DateUtils.newDateFrom(dateString, DateUtils.MMMddyyyyFormat);
    Assert.assertTrue(null == date);
    date = DateUtils.newDateFrom(dateString, DateUtils.yyyyMMddFormat);
    Assert.assertTrue(date != null);
  }

  protected String dateString = "1982-11-12";
}
