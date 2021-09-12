package com.study.bj.b2021.step1.brute_force.recursion;

public class 부분풀이 {

  public static void main(String[] args) {
    int[] arr = {0, -3, -10, -2, 1};

    int depth = 3;
    for(int i=1;i<=3;i++){
      System.out.println(i+" "+depth);
      int start = i;
      int end = depth;
      int totalSum=0;
      for(int j=start;j<=end;j++){
        totalSum+=arr[j];
      }
      System.out.println(totalSum);

    }

  }
}
