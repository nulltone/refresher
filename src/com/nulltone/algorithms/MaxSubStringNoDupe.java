package com.nulltone.algorithms;

import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given s string, Find max size of a sub-string, in which no duplicate chars present.
 */
public class MaxSubStringNoDupe {
  public static String findMaxSubstring(String text) {
    if (text == null || text.length() == 0) {
      return text;
    }

    char line[] = text.toLowerCase().toCharArray();
    Integer recent[] = new Integer[256];
    String longestSubstring = "";
    StringBuilder currString = new StringBuilder();

    // Indexes all characters in the string.
    for (int i = 0; i < line.length; i++) {
      Integer intChar = line[i] - 'a';
      if (recent[intChar] == null) {
        recent[intChar] = new Integer(i);
      } else {
        // Duplicate exists.
        if (longestSubstring.length() < currString.length()) {
          longestSubstring = currString.toString();
        }

        currString = new StringBuilder(text.substring(recent[intChar] + 1, i));
        recent[intChar] = new Integer(i);
      }
      currString.append(line[i]);
    }

    if (longestSubstring.length() < currString.length()) {
      longestSubstring = currString.toString();
    }

    System.out.printf("findMaxSubstring('%s') = '%s'\n", text, longestSubstring);
    return longestSubstring;
  }
}
