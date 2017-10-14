package com.engine.types;

public enum MonthType {
    JAN("January", "Jan", "01", 1),
    FEB("February", "Feb", "02", 2),
    MAR("March", "Mar", "03", 3),
    APR("April", "Apr", "04", 4),
    MAY("May", "May", "05", 5),
    JUN("June", "Jun", "06", 6),
    JUL("July", "Jul", "07", 7),
    AUG("August", "Aug", "08", 8),
    SEP("September", "Sep", "09", 9),
    OCT("October", "Oct", "10", 10),
    NOV("November", "Nov", "11", 11),
    DEC("December", "Dec", "12", 12),
    NUL("NUL", "NUL", "-1", -1);

    MonthType(String anEnglishName, String aShortName, String aMonthNumberWithZero, int aMonthNumber)
    {
      englishName = anEnglishName;
      shortName = aShortName;
      monthWithZero = aMonthNumberWithZero;
      monthNumber = aMonthNumber;
    }

    public String getEnglishName()
    {
      return englishName.toLowerCase();
    }

    public String getShortName()
    {
      return shortName.toLowerCase();
    }

    public String getMonthWithZero()
    {
        return monthWithZero;
    }

    public int getIntMonthNumber()
    {
      return monthNumber;
    }

    protected String englishName;
    protected String shortName;
    protected String monthWithZero;
    protected int monthNumber;
}
