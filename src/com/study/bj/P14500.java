package com.study.bj;

import java.util.Scanner;

/**
 * 테크로미노 https://www.acmicpc.net/problem/14500 틀린풀이
 */
public class P14500 {

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


  /////////////////////////////////////////
  static int x, y;
  static int[][] arr;
  static int MAX = -1;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    x = scan.nextInt();
    y = scan.nextInt();
    arr = new int[x][y];
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
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

    System.out.println(MAX);
  }

  public static void traverse(int[] temp1, int[] temp2) {
    for (int a = 0; a < x; a++) {
      for (int b = 0; b < y; b++) {
        int stdx = a;
        int stdy = b;
        int cnt = 0;
        int sum = 0;
        for (int c = 0; c < 4; c++) {
          stdx = a + temp1[c];
          stdy = b + temp2[c];
          if (stdx >= 0 && stdy >= 0 && stdx < x && stdy < y) {
            cnt += 1;
            sum += arr[stdx][stdy];
          }
          if (cnt == 4) {
            if (MAX < sum) {
              MAX = sum;
              sum = 0;
            }
          }
        }
      }
    }

  }
}
/*
 4 4
 0 0 0 0
 0 0 0 1
 0 0 0 2
 0 0 4 3

 4 4
0 0 0 0
0 0 0 0
0 1 0 0
0 2 3 4

4 4
0 0 0 0
0 0 2 1
0 0 3 0
0 0 4 0

4 4
0 0 0 0
0 0 0 0
0 1 2 3
0 0 0 4

4 4
0 0 0 0
0 0 1 0
0 0 2 3
0 0 0 4

4 4
0 0 0 0
0 0 0 0
0 0 3 4
0 1 2 0
 */