package com.nulltone.algorithms;

import java.util.Random;

public class Common {
  private static Random rand = new Random();

  public static void randomizeArray(int[] nums, int maxValue) {
    for (int i = 0; i < nums.length; i++) {
      nums[i] = rand.nextInt(maxValue);
    }
  }

  public static void randomize2dArray(int[][] nums, int maxValue) {
    for (int i = 0; i < nums.length; i++) {
      randomizeArray(nums[i], maxValue);
    }
  }
}
