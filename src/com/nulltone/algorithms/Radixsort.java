package com.nulltone.algorithms;

import java.util.LinkedList;
import java.util.Iterator;

public class Radixsort {

  @SuppressWarnings("unchecked")
  private LinkedList<Integer>[] buckets;
  private int[] elements;
  private int modulo;
  private int maxDigits;

  public Radixsort(int[] values, int baseNumber, int maxDigits) {
    this.modulo = baseNumber;
    this.elements = values;
    this.maxDigits = maxDigits;
    this.buckets = new LinkedList[baseNumber];

    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new LinkedList<Integer>();
    }
  }

  public void sort() {
    for (int nthDigit = 0; nthDigit < maxDigits; nthDigit++) {
      // Sort into buckets.
      for (int i = 0; i < elements.length; i++) {
        int bucketIndex = extractDigit(elements[i], nthDigit);
        buckets[bucketIndex].addLast(elements[i]);
      }

      // Inflate values into array.
      int index = 0;
      for (int i = 0; i < buckets.length; i++) {
        Iterator<Integer> iter = buckets[i].iterator();
        while (iter.hasNext()) {
          elements[index++] = iter.next();
        }
        // Reset bucket.
        buckets[i] = new LinkedList<Integer>();
      }
    }
  }

  /**
   * Extracts nth digit from a number. Starting with 0 from right to left.
   */
  public int extractDigit(int number, int nth) {
    int divider = number;
    for (int i = 0; i < nth; i++) {
      divider /= modulo;
    }
    return divider % modulo;
  }
}
