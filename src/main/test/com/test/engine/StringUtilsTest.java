package com.test.engine;

import com.engine.tools.StringUtils;
import com.engine.types.MonthType;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {
  @Test
  public void testMonthNumberWithZeroByString()
  {
    String month = StringUtils.getMonthNumberWithZeroByString("JAN");
    Assert.assertEquals(month, "01");
    month = StringUtils.getMonthNumberWithZeroByString("6");
    Assert.assertTrue(month == "06");
    month = StringUtils.getMonthNumberWithZeroByString("April");
    Assert.assertTrue(month == "04");
    month = StringUtils.getMonthNumberWithZeroByString("falsssse");
    Assert.assertTrue(month == MonthType.NUL.getMonthWithZero());
  }
}
