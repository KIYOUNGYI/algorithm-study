package com.study.bj.b2021.step1.simulation;

import java.util.Scanner;

public class P20055_컨베이어_벨트_위의_로봇 {


  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int[] a, box;
    int n = scan.nextInt();
    int k = scan.nextInt();
    a = new int[n * 2];
    box = new int[n * 2];
    int zero = 0;

    for (int i = 0; i < 2 * n; i++) {
      a[i] = scan.nextInt();
    }

    for (int t = 1; ; t++) {
      rotate(a);
      rotate(box);
      if (box[n - 1] == 1) {
        box[n - 1] = 0;
      }
      //check
      for (int i = n - 2; i >= 0; i--) {

        if (box[i] == 1) {
          if (box[i + 1] == 0 && a[i + 1] > 0) {
            box[i + 1] = 1;
            box[i] = 0;
            a[i + 1] -= 1;
            if (a[i + 1] == 0) {
              zero += 1;
            }
          }
        }
      }

      if (box[n - 1] == 1) {
        box[n - 1] = 0;
      }

      if (a[0] > 0) {
        box[0] = 1;
        a[0] -= 1;
        if (a[0] == 0) {
          zero += 1;
        }
      }
      if (zero >= k) {
        System.out.println(t);
        break;
      }

    }

  }

  private static void rotate(int[] x) {
    int temp = x[x.length - 1];
    for (int i = x.length - 1; i >= 1; i--) {
      x[i] = x[i - 1];
    }
    x[0] = temp;
  }

}
