package com.engine.exceptions;

public class ReadFileException extends Exception {
  public ReadFileException(String aFileName)
  {
    super((new StringBuilder()).append("Read\\p{Space}").append(aFileName)+ "\\p{Space}ERROR");
  }
}
