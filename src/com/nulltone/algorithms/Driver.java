package com.nulltone.algorithms;

import java.util.Arrays;

public class Driver {
  public static void main(String[] args) {
    runMergesort();
    runQuicksort();
    runRadixsort();
    testHeap();
    testSquareSum();
  }

  public static void runQuicksort() {
    System.out.println("Running QuickSort...");
    int[] numbers = new int[8];
    Common.randomizeArray(numbers, 100);
    System.out.printf("Initial numbers: %s\n", Arrays.toString(numbers));

    Quicksort.quicksort(numbers, 0, numbers.length - 1);
    System.out.printf(" Sorted numbers: %s\n\n", Arrays.toString(numbers));
  }

  public static void runMergesort() {
    System.out.println("Running MergeSort...");
    int[] numbers = new int[10];
    Common.randomizeArray(numbers, 100);
    System.out.printf("Initial numbers: %s\n", Arrays.toString(numbers));

    int[] sortedNumbers = Mergesort.mergesort(numbers);
    System.out.printf(" Sorted numbers: %s\n\n", Arrays.toString(sortedNumbers));
  }

  public static void testHeap() {
    System.out.println("Testing Heap...");
    int[] numbers = new int[10];
    Common.randomizeArray(numbers, 100);
    System.out.printf("Initial numbers: %s\n", Arrays.toString(numbers));

    Heap heap = Heap.heapify(numbers);
    System.out.printf("Heapified numbers: %s\n\n", Arrays.toString(heap.getHeap()));

    int removedNumber = heap.remove(new java.util.Random().nextInt(numbers.length));
    System.out.printf("Heap after removing %d: %s\n\n", removedNumber, Arrays.toString(heap.getHeap()));
  }

  public static void runRadixsort() {
    System.out.println("Running Radixsort...");
    int[] numbers = new int[10];
    Common.randomizeArray(numbers, 1000);
    System.out.printf("Initial numbers: %s\n", Arrays.toString(numbers));

    Radixsort radixsort = new Radixsort(numbers, 10, 3);
    radixsort.sort();
    System.out.printf(" Sorted numbers: %s\n\n", Arrays.toString(numbers));
  }

  public static void testSquareSum() {
    System.out.println("Running Square Sum...");

    int singleNumber[][] = {{7}};
    print2dArray(singleNumber);
    SubSquareSum singleSquare = new SubSquareSum(singleNumber);
    int sum = singleSquare.calculateSum(0, 0, 0, 0);

    int numbers[][] = {
      {49, 33, 53, 21, 62, 46, 54, 44},
      {38, 48, 4, 27, 25, 51, 62, 48},
      {47, 38, 21, 46, 21, 25, 12, 31},
      {62, 11, 59, 35, 7, 0, 20, 44},
      {18, 62, 1, 32, 62, 8, 50, 20},
      {34, 44, 49, 61, 56, 43, 7, 28},
      {6, 25, 50, 38, 29, 25, 5, 53},
      {34, 35, 32, 17, 56, 51, 42, 32},
    };
    print2dArray(numbers);

    SubSquareSum squareSum = new SubSquareSum(numbers);
    sum = squareSum.calculateSum(0, 0, 0, 0);
    sum = squareSum.calculateSum(0, 0, 6, 6);
    sum = squareSum.calculateSum(0, 0, 7, 7);
    sum = squareSum.calculateSum(2, 2, 4, 4);
  }

  private static void print2dArray(int numbers[][]) {
    System.out.printf("[\n");
    for (int i = 0; i < numbers.length; i++) {
      System.out.printf("  %s,\n", Arrays.toString(numbers[i]));
    }
    System.out.printf("]\n");
  }
}
