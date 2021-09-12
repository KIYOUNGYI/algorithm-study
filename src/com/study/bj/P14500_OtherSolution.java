package com.study.bj;

import java.util.Scanner;

public class P14500_OtherSolution
{
  private static final NPoint2[][] SHAPES = new NPoint2[][] {
      // long
      { new NPoint2(0, 1), new NPoint2(0, 2), new NPoint2(0, 3) }
      , { new NPoint2(1, 0), new NPoint2(2, 0), new NPoint2(3, 0) }

      // square
      , { new NPoint2(0, 1), new NPoint2(1, 0), new NPoint2(1, 1) }

      // ㄴ
      , { new NPoint2(1, 0), new NPoint2(2, 0), new NPoint2(2, 1) }
      , { new NPoint2(0, 1), new NPoint2(1, 1), new NPoint2(2, 1) }
      , { new NPoint2(0, 1), new NPoint2(-1, 1), new NPoint2(-2, 1) }
      , { new NPoint2(0, 1), new NPoint2(1, 0), new NPoint2(2, 0) }

      , { new NPoint2(0, 1), new NPoint2(0, 2), new NPoint2(1, 2) }
      , { new NPoint2(0, 1), new NPoint2(0, 2), new NPoint2(1, 0) }
      , { new NPoint2(1, 0), new NPoint2(1, 1), new NPoint2(1, 2) }
      , { new NPoint2(0, 1), new NPoint2(0, 2), new NPoint2(-1, 2) }

      // 번개
      , { new NPoint2(0, 1), new NPoint2(1, 0), new NPoint2(-1, 1) }
      , { new NPoint2(0, 1), new NPoint2(1, 1), new NPoint2(1, 2) }
      , { new NPoint2(1, 0), new NPoint2(1, 1), new NPoint2(2, 1) }
      , { new NPoint2(0, 1), new NPoint2(-1, 1), new NPoint2(-1, 2) }

      // T
      , { new NPoint2(0, 1), new NPoint2(0, 2), new NPoint2(1, 1) }
      , { new NPoint2(0, 1), new NPoint2(1, 1), new NPoint2(-1, 1) }
      , { new NPoint2(0, 1), new NPoint2(0, 2), new NPoint2(-1, 1) }
      , { new NPoint2(1, 0), new NPoint2(1, 1), new NPoint2(2, 0) }
  };

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    final int height = scanner.nextInt();
    final int width = scanner.nextInt();
    final int[][] numbers = new int[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        numbers[i][j] = scanner.nextInt();
      }
    }

    int sum = sumPoint(numbers, height, width);
    System.out.println(sum);
  }

  private static boolean isOver(final int x, final int y, final int height, final int width) {
    return isOverHeight(x, height) || isOverWidth(y, width);
  }

  private static boolean isOverWidth(final int y, final int width) {
    return y < 0 || y >= width;
  }

  private static boolean isOverHeight(final int x, final int height) {
    return x < 0 || x >= height;
  }

  private static int sumPoint(final int[][] numbers, final int height, final int width) {
    int max = 0;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {

        for (int k = 0; k < SHAPES.length; k++) {
          int sum = numbers[i][j];
          for (int l = 0; l < SHAPES[k].length; l++) {
            int x = i + SHAPES[k][l].getX();
            int y = j + SHAPES[k][l].getY();
            if (isOver(x, y, height, width)) {
              sum = 0;
              break;
            } else {
              sum += numbers[x][y];
            }
          }
          max = Integer.max(max, sum);
        }

      }
    }
    return max;
  }
}

class NPoint2 {
  private final int x;
  private final int y;

  public NPoint2(final int x, final int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

}
