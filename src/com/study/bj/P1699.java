package com.study.bj;

import java.util.Scanner;


public class P1699 {

  static int[] arr;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    arr = new int[n + 1];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.MAX_VALUE;
    }
    arr[1] = 1;
//    arr[2]=2;
    if (n == 1) {
      System.out.println(1);
      return;
    }
    arr[2] = 2;
    int x = (int)Math.sqrt(n);
    for (int i = 2; i <= x; i++) {
      int t = i * i;
      if (t <= n) {
        arr[t] = 1;
      }
    }
    for (int i = 2; i <= n; i++) {
//      System.out.println("i:"+i);
//      if(arr[i]==0)
//      {
      for (int j = i - 1; j >= i / 2; j--) {
//          System.out.println("t:"+i+" a:"+j+" b:"+(i-j));
        int temp = arr[j] + arr[i - j];
        if (arr[i] > temp) {
          arr[i] = temp;
        }
      }
//      }
    }
//    for(int i=1;i<=n;i++) { System.out.println("arr["+i+"] : " + arr[i]); }
    System.out.println(arr[n]);
  }
}
