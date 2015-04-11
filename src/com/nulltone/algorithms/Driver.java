package com.nulltone.algorithms;

import java.util.Arrays;

public class Driver {
  public static void main(String[] args) {
    runMergesort();
    runQuicksort();
    testHeap();
  }

  public static void runQuicksort() {
    System.out.println("Running QuickSort...");
    int[] numbers = new int[8];
    Common.randomizeArray(numbers);
    System.out.printf("Initial numbers: %s\n", Arrays.toString(numbers));

    Quicksort.quicksort(numbers, 0, numbers.length - 1);
    System.out.printf(" Sorted numbers: %s\n\n", Arrays.toString(numbers));
  }

  public static void runMergesort() {
    System.out.println("Running MergeSort...");
    int[] numbers = new int[10];
    Common.randomizeArray(numbers);
    System.out.printf("Initial numbers: %s\n", Arrays.toString(numbers));

    int[] sortedNumbers = Mergesort.mergesort(numbers);
    System.out.printf(" Sorted numbers: %s\n\n", Arrays.toString(sortedNumbers));
  }

  public static void testHeap() {
    System.out.println("Testing Heap...");
    int[] numbers = new int[10];
    Common.randomizeArray(numbers);
    System.out.printf("Initial numbers: %s\n", Arrays.toString(numbers));

    Heap heap = Heap.heapify(numbers);
    System.out.printf("Heapified numbers: %s\n\n", Arrays.toString(heap.getHeap()));

    int removedNumber = heap.remove(new java.util.Random().nextInt(numbers.length));
    System.out.printf("Heap after removing %d: %s\n\n", removedNumber, Arrays.toString(heap.getHeap()));
  }
}
