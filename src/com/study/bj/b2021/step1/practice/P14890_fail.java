package com.study.bj.b2021.step1.practice;

import java.util.Scanner;

public class P14890_fail {

  static int score = 0;
  static int n, l;
  static int[][] arr, brr;
  static boolean[][] v;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    l = scan.nextInt();
    arr = new int[n][n];
    brr = new int[n][n];
    v = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = scan.nextInt();
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        brr[i][j] = arr[j][i];
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(brr[i][j]+" ");
      }
      System.out.println();
    }


    solution1(arr);
    System.out.println(score);
    initV();
    System.out.println("brr start");
    solution2(brr);
    System.out.println(score);
  }

  private static void solution2(int[][] tempArr) {

    for (int i = 0; i < n; i++) {
      boolean flag = true;
      for (int j = 0; j < n - 1; j++) {
        int t1 = j;
        int t2 = j + 1;

        System.out.println(t1 + " " + t2 + " flag:" + flag);
        System.out.println(arr[t1][i] + " " + arr[t2][i]);
        if (abs(tempArr[t1][i] - tempArr[t2][i]) >= 2) {
          flag = false;
          break;
        } else if (tempArr[t1][i] - tempArr[t2][i] == 1) {

          int std = tempArr[t2][i];
          //기준 t2 로 잡자
          if (t2 + l > n) {
            flag = false;
            break;
          }
          for (int x = t2; x < t2 + l; x++) {
            if (tempArr[x][i] != std) {
              flag = false;
              break;
            } else {
              v[x][i] = true;
            }
          }


        } else if (tempArr[t1][i] - tempArr[t2][i] == -1) {
//          System.out.println("a[" + i + "][" + t1 + "]-a[" + i + "][" + t2 + "]:" + (arr[i][t1] - arr[i][t2]));
          int temp = tempArr[t1][i];//이전 좌표점 확인
//          System.out.println("Temp:" + temp);
          if (t1 - l < 0) {
            flag = false;
            break;//좌표 벗어나면 종료
          }
          System.out.println("!!!+" + flag);
          for (int k = t1; k > t1 - l; k--) {
            if (tempArr[k][i] != temp || v[k][i] == true) {
              flag = false;
              break;
            }
          }
          System.out.println("@@@@+" + flag);
          for (int k = t1; k > t1 - l; k--) {
            v[k][i] = true;
          }
          System.out.println("####+" + flag);
          j = t2;//현재것 다음것으로 이동
        }

      }
      System.out.println(i + "-----------" + flag);
      if (flag) {
        score += 1;
      }
      System.out.println("score:" + score);
    }

  }

  private static void solution1(int[][] tempArr) {

    for (int i = 0; i < n; i++) {
      boolean flag = true;
      for (int j = 0; j < n - 1; j++) {
        int t1 = j;
        int t2 = j + 1;

        System.out.println(t1 + " " + t2 + " flag:" + flag);
        System.out.println(arr[i][t1] + " " + arr[i][t2]);
        if (abs(tempArr[i][t1] - tempArr[i][t2]) >= 2) {
          flag = false;
          break;
        } else if (tempArr[i][t1] - tempArr[i][t2] == 1) {

          int std = tempArr[i][t2];
          //기준 t2 로 잡자
          if (t2 + l > n) {
            flag = false;
            break;
          }
          for (int x = t2; x < t2 + l; x++) {
            if (tempArr[i][x] != std) {
              flag = false;
              break;
            } else {
              v[i][x] = true;
            }
          }


        } else if (tempArr[i][t1] - tempArr[i][t2] == -1) {
          System.out.println("a[" + i + "][" + t1 + "]-a[" + i + "][" + t2 + "]:" + (arr[i][t1] - arr[i][t2]));
          int temp = tempArr[i][t1];//이전 좌표점 확인
//          System.out.println("Temp:" + temp);
          if (t1 - l < 0) {
            flag = false;
            break;//좌표 벗어나면 종료
          }
          System.out.println("!!!+" + flag);
          for (int k = t1; k > t1 - l; k--) {
            if (tempArr[i][k] != temp || v[i][k] == true) {
              flag = false;
              break;
            }
          }
          System.out.println("@@@@+" + flag);
          for (int k = t1; k > t1 - l; k--) {
            v[i][k] = true;
          }
          System.out.println("####+" + flag);
          j = t2;//현재것 다음것으로 이동
        }

      }
      System.out.println(i + "-----------" + flag);
      if (flag) {
        score += 1;
      }
      System.out.println("score:" + score);
    }
  }

  private static void initV() {
    v = new boolean[n][n];
  }

  private static int abs(int x) {
    return x > 0 ? x : -x;
  }

}
