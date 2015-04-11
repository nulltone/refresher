package com.nulltone.algorithms;

/**
 * Mergesort using top-down approach.
 */
public class Mergesort {

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
    for (int i = 0; i < left_half; i++) {
      left[i] = nums[i];
    }

    // Fill the right half.
    for (int i = 0; i < right_half; i++) {
      right[i] = nums[left_half + i];
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
