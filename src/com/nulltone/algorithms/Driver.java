package com.nulltone.algorithms;

import java.util.Arrays;

public class Driver {
  public static void main(String[] args) {
    runMergesort();
    runQuicksort();
    runRadixsort();
    testHeap();
    testSquareSum();
    testMaxSubstring();
    testBinaryTree();
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
    Common.print2dArray(singleNumber);
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
    Common.print2dArray(numbers);

    SubSquareSum squareSum = new SubSquareSum(numbers);
    sum = squareSum.calculateSum(0, 0, 0, 0);
    sum = squareSum.calculateSum(0, 0, 6, 6);
    sum = squareSum.calculateSum(0, 0, 7, 7);
    sum = squareSum.calculateSum(2, 2, 4, 4);

    int simpleNumbers[][] = {
      {1, 1, 1},
      {1, 1, 1},
      {1, 1, 1}
    };
    Common.print2dArray(simpleNumbers);

    squareSum = new SubSquareSum(simpleNumbers);
    sum = squareSum.calculateSum(1, 1, 2, 2);
  }

  public static void testBinaryTree() {
    System.out.println("Running SameBinaryTree...");

    int[] tree1 = {1, 2, 3, 4, 5, 6, 7 ,8, 9};
    int[] tree2 = {1, 3, 2, 7, 8, 9, 6, 5, 4};

    //String strIsSame = SameBinaryTree.isSameTree(tree1, tree2) ? "is the same as" : "is NOT the same as";
    //System.out.printf("%s %s %s\n", Arrays.toString(tree1), strIsSame, Arrays.toString(tree2));
  }

  public static void testMaxSubstring() {
    System.out.println("Running MaxSubStringNoDupe...");

    assert(MaxSubStringNoDupe.findMaxSubstring("abcdefghij").equals("abcdefghij"));
    assert(MaxSubStringNoDupe.findMaxSubstring("abcdefghaij").equals("bcdefghaij"));
    assert(MaxSubStringNoDupe.findMaxSubstring("abcadefghij").equals("bcadefghij"));
    assert(MaxSubStringNoDupe.findMaxSubstring("abcadefghiaj").equals("bcadefghi"));
    assert(MaxSubStringNoDupe.findMaxSubstring("abcadebfghiaj").equals("cadebfghi"));
    assert(MaxSubStringNoDupe.findMaxSubstring("aaaaaa").equals("a"));
    assert(MaxSubStringNoDupe.findMaxSubstring("aaabaaa").equals("ab"));
  }
}
