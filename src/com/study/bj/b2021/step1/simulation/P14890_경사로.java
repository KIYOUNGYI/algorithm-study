package com.study.bj.b2021.step1.simulation;

import java.util.Scanner;

/**
 * 폭파
 */
public class P14890_경사로 {

  static int n, l;
  static int[][] arr;
  static boolean[][] visit;
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    input();

    solution();

  }

  private static void solution() {

    boolean flag = true;

    for (int i = 1; i <= n; i++) {
      int s = 0;
      int initialHeight = arr[i][1];
      int direction = 0;

      for (int j = 1; j <= n - 1; j++) {

        System.out.println(j + " " + i);

        int t = arr[j][i];

        if (t == arr[j + 1][i]) {
          s += 1;
        } else {
          if (abs(t - arr[j + 1][i]) >= 2) {
            flag = false;
            break;
          } else if (abs(t - arr[j + 1][i]) == 1) {

            int tempHeight = arr[j + 1][i];

            int cnt = 0;
            for (int k = j + 1; k < j + 1 + l; k++) {

              if (arr[k][i] == tempHeight) {
                cnt+=1;
              } else {
                System.out.println("break!");
                flag = false;
                break;
              }
            }
            if(cnt==l){
              initialHeight = tempHeight;
            }
          }
        }

        if(!flag){break;}

      }
      flag = true;
      System.out.println("----------");
    }

//    for (int i = 1; i <= n; i++) {
//      for (int j = 1; j <= n; j++) {
//        System.out.println(i+" "+j);
//      }
//    }

  }

  private static int abs(int x) {
    return x > 0 ? x : -x;
  }

  private static void input() {
    n = scan.nextInt();
    l = scan.nextInt();
    arr = new int[n + 50][n + 50];
    visit = new boolean[n+50][n+50];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        arr[i][j] = scan.nextInt();
      }
    }
  }

  private static void printArr() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

}
