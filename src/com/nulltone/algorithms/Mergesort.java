package com.nulltone.algorithms;

import java.util.Arrays;

public class Mergesort {
  public static void main(String args[]) {
    int[] numbers = new int[10];
    Common.randomizeArray(numbers);
    System.out.printf("Initial numbers: %s\n", Arrays.toString(numbers));

    int[] sortedNumbers = mergesort(numbers);
    System.out.printf(" Sorted numbers: %s\n", Arrays.toString(sortedNumbers));
  }

  public static int[] mergesort(int[] nums) {
    // Single element is considered sorted.
    if (nums.length <= 1) {
      return nums;
    }
  
    int left_half = (int) (nums.length/2);
    int right_half = nums.length - left_half;
    int[] left = new int[left_half];
    int[] right = new int[right_half];

    // Fill the left half.
    for (int li = 0; li < left_half; li++) {
      left[li] = nums[li];
    }

    // Fill the right half.
    for (int ri = 0; ri < right_half; ri++) {
      right[ri] = nums[left_half + ri];
    }

    // Keep splitting recursively.
    left = mergesort(left);
    right = mergesort(right);

    // Merge the left and right halves.
    return merge(left, right);
  }

  public static int[] merge(int[] left, int[] right) {
    int leftIndex = 0;
    int rightIndex = 0;
    int newIndex = 0;
    int[] newArray = new int[left.length + right.length];

    // Sort the elements until either left or right half depletes.
    while (leftIndex < left.length && rightIndex < right.length) {
      newArray[newIndex++] = (left[leftIndex] < right[rightIndex]) ? left[leftIndex++] : right[rightIndex++];
    }

    // Fill the remaining left elements.
    while (leftIndex < left.length) {
      newArray[newIndex++] = left[leftIndex++];
    }

    // Fill the remaining right elements.
    while (rightIndex < right.length) {
      newArray[newIndex++] = right[rightIndex++];
    }

    // Return the new and sorted array.
    return newArray;
  }
}
