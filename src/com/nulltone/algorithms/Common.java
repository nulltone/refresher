package com.nulltone.algorithms;

import java.util.Random;

public class Common {
  public static void randomizeArray(int[] nums) {
    Random rand = new Random();
    for (int i = 0; i < nums.length; i++) {
      nums[i] = rand.nextInt(100);
    }
  }
}
