package com.nulltone.algorithms;

import java.lang.IllegalArgumentException;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Group Anagrams 
 * input = ["star, astr, car, rac, st"] 
 * output = [["star, astr"],["car","rac"],["st"]);
 */
public class GroupAnagrams {
  public static List<List<String>> groupAnagrams(String words[]) {
    List<List<String>> anagramGroups = new ArrayList<>();
    HashMap<String, List<String>> anagramMap = new HashMap<>();

    for (int i = 0; i < words.length; i++) {
      byte histogram[] = new byte[26];
      for (int j = 0; j < words[i].length(); j++) {
        // Counts frequency of each character.
        String lowerWord = words[i].toLowerCase();
        histogram[lowerWord.charAt(j) - 'a']++;
      }
      // Generates the hash.
      String anagramHash = hashHistogram(histogram);
      // Append the word to the hashed bucket.
      if (!anagramMap.containsKey(anagramHash)) {
        List<String> newList = new ArrayList<>();
        anagramMap.put(anagramHash, newList);
      }
      anagramMap.get(anagramHash).add(words[i]);
    }

    // Create a grouped list of strings and then return it.
    for (String key : anagramMap.keySet()) {
      anagramGroups.add(anagramMap.get(key));
      System.out.println("anagramMap['" + key + "']: " + anagramMap.get(key));
    }

    return anagramGroups;
  }

  private static String hashHistogram(byte histogram[]) throws IllegalArgumentException {
    if (histogram.length != 26) {
      throw new IllegalArgumentException("The histogram must have 26 elements!");
    }

    char letter = 'a';
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < histogram.length; i++) {
      builder.append((char)(letter + i)).append("" + histogram[i]);
    }
    return builder.toString();
  }
}
