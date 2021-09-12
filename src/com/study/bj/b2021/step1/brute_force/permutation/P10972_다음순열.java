package com.study.bj.b2021.step1.brute_force.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class P10972_다음순열 {

  static int n;
  static int[] arr;
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();
    arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scan.nextInt();
    }


    int i = 1;
    for (int j = n - 1; j >= 0; j--) {

      if(j==0){
        System.out.println(-1);
        return;
      }

      if (arr[j] < arr[j - 1]) {
//        t = j;
//        System.out.println(j + " " + (j - 1));
      } else {
        i = j - 1;
        break;
      }
    }
    if(i<=0){
      System.out.println("-1");
      return;
    }

    //(i)
    int j = 0;
    int x = arr[i];
    for (int t = i + 1; t < n; t++) {
        if(arr[t]==x+1){
          j = t;
        }
    }


    int temp1 = arr[i];
    int temp2 = arr[j];

    arr[i] = temp2;
    arr[j] = temp1;

//    System.out.println(Arrays.toString(arr));
    //n=7,i=2
    int[] t = new int[n-(i+1)];
    for(int k=0;k<n-(i+1);k++){
//      System.out.println(k+(i+1));
      t[k] = arr[k+(i+1)];
    }
    Arrays.sort(t);

    for(int b=0;b<=i;b++){
      System.out.print(arr[b]+" ");
    }
    for(int b=0;b<t.length;b++){
      System.out.print(t[b]+" ");
    }
//    System.out.println(Arrays.toString(t));

  }
}
