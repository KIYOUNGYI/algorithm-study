package com.study.bj.b2021.step1.brute_force.brute;

import java.util.Scanner;

public class P14500_테트로미노 {

  static Scanner scan = new Scanner(System.in);
  static int sero, garo;
  static int[][] arr;
  static int max = 0;

  //aaaa
  static int[] dx1 = {0, 0, 0, 0};
  static int[] dy1 = {0, 1, 2, 3};
  //a
  //a
  //a
  //a
  static int[] dx2 = {0, 1, 2, 3};
  static int[] dy2 = {0, 0, 0, 0};
  //////////////////////////////////
  // aa
  //aa
  static int[] dx3 = {0, 0, -1, -1};
  static int[] dy3 = {0, 1, 1, 2};
  //a
  //aa
  // a
  static int[] dx4 = {-1, 0, 0, 1};
  static int[] dy4 = {0, 0, 1, 1};
  //aa
  // aa
  static int[] dx5 = {0, 0, 1, 1};
  static int[] dy5 = {-1, 0, 0, 1};
  // a
  //aa
  //a
  static int[] dx6 = {1, 0, 0, -1};
  static int[] dy6 = {0, 0, 1, 1};

  //////////////////////////////////
  //aa
  //aa
  static int[] dx7 = {0, 0, 1, 1};
  static int[] dy7 = {0, 1, 0, 1};
  //////////////////////////////////
  //aaa
  //a
  static int[] dx8 = {0, 0, 0, 1};
  static int[] dy8 = {0, 1, 2, 0};
  //a
  //a
  //aa
  static int[] dx9 = {0, 1, 2, 2};
  static int[] dy9 = {0, 0, 0, 1};

  //  a
  //aaa
  static int[] dx10 = {0, 0, 0, -1};
  static int[] dy10 = {0, 1, 2, 2};
  //aa
  // a
  // a
  static int[] dx11 = {0, 0, 1, 2};
  static int[] dy11 = {-1, 0, 0, 0};
  //////////////////////////////////////////
  // a
  //aaa
  static int[] dx12 = {0, 0, 0, -1};
  static int[] dy12 = {-1, 0, 1, 0};
  // a
  // aa
  // a
  static int[] dx13 = {-1, 0, 1, 0};
  static int[] dy13 = {0, 0, 0, 1};

  // aaa
  //  a
  static int[] dx14 = {0, 0, 0, 1};
  static int[] dy14 = {-1, 0, 1, 0};

  // a
  //aa
  // a
  static int[] dx15 = {-1, 0, 1, 0};
  static int[] dy15 = {0, 0, 0, -1};

  // a
  // a
  //aa
  static int[] dx16 = {0, 0, -1, -2};
  static int[] dy16 = {0, 1, 1, 1};

  //a
  //aaa
  static int[] dx17 = {0, 1, 1, 1};
  static int[] dy17 = {0, 0, 1, 2};

  //aa
  //a
  //a
  static int[] dx18 = {0, 0, 1, 2};
  static int[] dy18 = {0, 1, 0, 0};

  //aaa
  //  a
  static int[] dx19 = {0, 0, 0, 1};
  static int[] dy19 = {0, 1, 2, 2};


  public static void main(String[] args) {

    sero = scan.nextInt();
    garo = scan.nextInt();
    arr = new int[sero][garo];
    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        arr[i][j] = scan.nextInt();
      }
    }

    traverse(dx1, dy1);
    traverse(dx2, dy2);
    traverse(dx3, dy3);
    traverse(dx4, dy4);
    traverse(dx5, dy5);
    traverse(dx6, dy6);
    traverse(dx7, dy7);
    traverse(dx8, dy8);
    traverse(dx9, dy9);
    traverse(dx10, dy10);
    traverse(dx11, dy11);
    traverse(dx12, dy12);
    traverse(dx13, dy13);
    traverse(dx14, dy14);
    traverse(dx15, dy15);
    traverse(dx16, dy16);
    traverse(dx17, dy17);
    traverse(dx18, dy18);
    traverse(dx19, dy19);

    System.out.println(max);
  }

  private static void traverse(int[] arr1, int[] arr2) {

    for (int x = 0; x < sero; x++) {

      for (int y = 0; y < garo; y++) {

        int tx = x;
        int ty = y;
        int cnt = 0;
        int sum = 0;
        for (int t = 0; t < 4; t++) {
          int dx = tx + arr1[t];
          int dy = ty + arr2[t];
          if (dx >= 0 && dx < sero && dy >= 0 && dy < garo) {
            sum += arr[dx][dy];
            cnt += 1;
          }
        }
        if (cnt == 4) {
          if (max < sum) {
            max = sum;
          }
        }
      }
    }
  }


}
