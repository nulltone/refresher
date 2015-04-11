package com.nulltone.algorithms;

public class Quicksort {

  public static void quicksort(int[] nums, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(nums, low, high);
      quicksort(nums, low, pivotIndex - 1);
      quicksort(nums, pivotIndex + 1, high);
    }
  }


  public static int partition(int[] nums, int low, int high) {
    int pivotIndex = findMedian(nums, low, high);
    int pivotValue = nums[pivotIndex];

    // Move pivot out of the way
    swap(nums, pivotIndex, high);
    int newIndex = low;

    for (int i = low; i < high; i++) {
      if (nums[i] < pivotValue) {
        swap(nums, i, newIndex);
        newIndex++;
      }
    }

    // Restore pivot back into the right position.
    swap(nums, high, newIndex);

    return newIndex;
  }


  public static void swap(int[] nums, int index1, int index2) {
      int temp = nums[index1];
      nums[index1] = nums[index2];
      nums[index2] = temp;
  }


  public static int findMedian(int[] nums, int num1, int num3) {
    int num2 = (int) ((num1 + num3) / 2);
    int median = -1;

    if (nums[num1] <= nums[num2] && nums[num1] >= nums[num3]
        || nums[num1] >= nums[num2] && nums[num1] <= nums[num3]) {
      median = num1;
    }
    if (nums[num2] <= nums[num3] && nums[num2] >= nums[num1]
        || nums[num2] >= nums[num3] && nums[num2] <= nums[num1]) {
      median = num2;
    }
    if (nums[num3] <= nums[num2] && nums[num3] >= nums[num1]
        || nums[num3] >= nums[num2] && nums[num3] <= nums[num1]) {
      median = num3;
    }

    return median;
  }
}
