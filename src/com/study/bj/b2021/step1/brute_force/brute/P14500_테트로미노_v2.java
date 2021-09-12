package com.study.bj.b2021.step1.brute_force.brute;

import java.util.Scanner;

public class P14500_테트로미노_v2 {

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
    Scanner scan = new Scanner(System.in);
    sero = scan.nextInt();
    garo = scan.nextInt();
    arr = new int[sero][garo];

    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        arr[i][j] = scan.nextInt();
      }
    }

    solution2(dx1, dy1);
    solution2(dx2, dy2);
    solution2(dx3, dy3);
    solution2(dx4, dy4);
    solution2(dx5, dy5);
    solution2(dx6, dy6);
    solution2(dx7, dy7);
    solution2(dx8, dy8);
    solution2(dx9, dy9);
    solution2(dx10, dy10);
    solution2(dx11, dy11);
    solution2(dx12, dy12);
    solution2(dx13, dy13);
    solution2(dx14, dy14);
    solution2(dx15, dy15);
    solution2(dx16, dy16);
    solution2(dx17, dy17);
    solution2(dx18, dy18);
    solution2(dx19, dy19);

    System.out.println(max);
    scan.close();
  }


  private static void solution2(int[] a, int[] b) {
    for (int x = 0; x < sero; x++) {

      for (int y = 0; y < garo; y++) {

        int tx = x;
        int ty = y;
        int cnt = 0;
        int sum = 0;
        for (int t = 0; t < 4; t++) {
          int dx = tx + a[t];
          int dy = ty + b[t];
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
