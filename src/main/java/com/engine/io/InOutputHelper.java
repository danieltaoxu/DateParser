package com.engine.io;

import com.engine.tools.StringUtils;
import com.sun.media.jfxmedia.logging.Logger;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 *  Input Output File Helper
 */
public class InOutputHelper {
  /**
   * Read a text file and get string list by regex
   * */
  public static List<String> readTextFile(String aFileName)
  {
    BufferedReader bufferedReader;
    List<String> words = new Vector<>();
    try
    {
      String regex = getProperty("com.parser.regex");
      FileReader fileReader = new FileReader(aFileName);
      bufferedReader = new BufferedReader(fileReader);
      String aLine;
      while((aLine = bufferedReader.readLine()) != null)
      {
        words.addAll(Arrays
            .stream(aLine.split(regex))
            .filter(word -> !word.isEmpty())
            .collect(Collectors.toList()));
      }
      bufferedReader.close();
    }
    catch (IOException e)
    {
      Logger.logMsg(Logger.ERROR, "Read " + aFileName +" Error");
    }
    return words;
  }

  /**
   * Write file, here we don't use for this exercise
   * */
  public static void writeFile(String aFileName)
  {
    File file = new File(aFileName);
    if (file.exists())
      file.delete();
    //PrintWriter pw = new PrintWriter(file);
    //pw.close();
  }

  /**
   * Get property for config.properties
   * */
  public static String getProperty(String aPropertyName)
  {
    return config.containsKey(aPropertyName) ? config.getString(aPropertyName) : StringUtils.Empty;
  }

  private static final String CONFIG_PROPERTIES = "config";

  private static final ResourceBundle config = ResourceBundle.getBundle(CONFIG_PROPERTIES);
}


