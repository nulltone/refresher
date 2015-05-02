package com.nulltone.algorithms;

public class SubSquareSum {
  private int rectSum[][] = null;

  public SubSquareSum(int[][] numbers) {
    rectSum = new int[numbers.length][numbers[0].length];

    for (int i = 0; i < numbers.length; i++) {
      int rowSum = 0;
      for (int j = 0; j < numbers[i].length; j++) {
        rowSum += numbers[i][j];
        if (i > 0) {
          rectSum[i][j] = rowSum + rectSum[i - 1][j];
        } else {
          rectSum[i][j] = rowSum;
        }
      }
    }
  }

  public int calculateSum(int x0, int y0, int x1, int y1) {
    if (x0 > x1 || y0 > y1) {
      System.out.println("x0, y0 must be less than x1, y1, respectively.");
      return 0;
    }
    int sum = rectSum[x1][y1];
    if (y0 > 0) {
      sum -= rectSum[y0 - 1][x1];
    }
    if (x0 > 0) {
      sum -= rectSum[y1][x0 - 1] - rectSum[y0 - 1][x0 - 1];
    }
    System.out.printf("Sub square sum of (%d, %d) and (%d, %d): %s\n\n", x0, y0, x1, y1, sum);
    return sum;
  }
}
