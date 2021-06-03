package com.sachin.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

  public static void main(String args[]) {
    punctTest();
    Map<Integer, Integer> i = new HashMap<>();
    // String to be scanned to find the pattern.
    // regExtest();
  }

  private static void regExtest() {
    String line = "This order was placed for QT3001! OK?";
    String pattern = "(.*)(\\d+)(.*)";

    // Create a Pattern object
    Pattern r = Pattern.compile(pattern);

    // Now create matcher object.
    Matcher m = r.matcher(line);
    if (m.find()) {
      System.out.println("Found value: " + m.group(0));
      System.out.println("Found value: " + m.group(1));
      System.out.println("Found value: " + m.group(2));
      System.out.println("Found value: " + m.group(3));
    } else {
      System.out.println("NO MATCH");
    }
  }

  private static void punctTest() {
    Pattern p = Pattern.compile("\\p{P}");

    Matcher m = p.matcher("One day! when I was walking. I found your pants? just kidding...");
    int count = 0;
    while (m.find()) {
      count++;
      System.out.println("\nMatch number: " + count);
      System.out.println("start() : " + m.start());
      System.out.println("end()   : " + m.end());
      System.out.println("group() : " + m.group());
    }
  }
}
