package com.nulltone.algorithms;

import java.lang.Math;

public class Heap {

  private int size = 0;
  private Integer[] heap;

  private Heap(int size) {
    heap = new Integer[size];
  }


  public static Heap heapify(int[] values) {
    Heap heap = new Heap(values.length);
    for (int i = 0; i < values.length; i++) {
      heap.insert(values[i]);
    }
    return heap;
  }

  public void insert(int val) {
    if (size >= heap.length) {
      // exception
    }

    int insertIndex = size;
    heap[size++] = new Integer(val);
    siftUp(insertIndex);
  }

  public void siftUp(int pos) {
    if (parentValue(pos) < heap[pos]) {
      int newPos = swapWithParent(pos);
      if (newPos >= 0) {
        siftUp(newPos);
      }
    }
  }

  public void siftDown(int pos) {
    int maxChild = heap[pos];
    int maxChildPos = pos;

    if (rightValue(pos) > leftValue(pos)) {
      maxChild = rightValue(pos);
      maxChildPos = rightChildPosition(pos);
    } else {
      maxChild = leftValue(pos);
      maxChildPos = leftChildPosition(pos);
    }

    if (heap[pos] < maxChild) {
      int newPos = swapWithParent(maxChildPos);
      if (newPos >= 0) {
        siftDown(maxChildPos);
      }
    }
  }

  public int leftChildPosition(int currPos) {
    return 2 * currPos + 1;
  }

  public int rightChildPosition(int currPos) {
    return 2 * currPos + 2;
  }

  public int leftValue(int currPos) {
    int leftPos = leftChildPosition(currPos);
    return (leftPos < heap.length) ? heap[leftPos] : -1;
  }

  public int rightValue(int currPos) {
    int rightPos = rightChildPosition(currPos);
    return (rightPos < heap.length) ? heap[rightPos] : -1;
  }

  public int swapWithParent(int childPos) {
    int parentPos = getParentPosition(childPos);
    if (parentPos >= 0) {
      int temp = heap[parentPos];
      heap[parentPos] = heap[childPos];
      heap[childPos] = temp;
    }
    return parentPos;
  }

  public void swap(int pos1, int pos2) {
      int temp = heap[pos1];
      heap[pos1] = heap[pos2];
      heap[pos2] = temp;
  }

  public int getParentPosition(int currentPosition) {
    if (currentPosition > 0) {
      return (int) ((currentPosition - 1) / 2);
    } else {
      return -1;
    }
  }

  public int parentValue(int currentPosition) {
    return (getParentPosition(currentPosition) >= 0) ? heap[getParentPosition(currentPosition)] : -1;
  }

  public Integer[] getHeap() {
    return heap;
  }

  public int remove(int pos) {
    int removedNumber = heap[pos];
    swap(pos, size - 1);
    heap[size - 1] = null;
    size -= 1;
    siftDown(pos);
    return removedNumber;
  }
}
