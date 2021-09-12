package com.study.bj.b2021.step1.dynamic_programming.part1;

import java.util.Arrays;
import java.util.Scanner;

public class P11053_가장_큰_증가_부분_수열 {

  static int n;
  static int[] a;
  static int[] d;//내가 생각하는게 맞긴 했음 .

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    a = new int[n];
    d = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = scan.nextInt();
    }

    for (int i = 0; i < n; i++) {
      d[i] = 1;
      for (int j = 0; j < i; j++) {
        if (a[i] > a[j]) {

          int t = d[j] + 1;
          if (t > d[i]) {
            d[i] = t;
          }
        }
      }
    }

    int max=0;
    for(int i=0;i<n;i++){
      if(d[i]>max){
        max = d[i];
      }
    }

    System.out.println(Arrays.toString(d));
    System.out.println(max);
  }
}
