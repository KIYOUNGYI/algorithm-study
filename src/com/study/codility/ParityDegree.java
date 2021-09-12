package com.study.codility;

import java.util.Arrays;

public class ParityDegree {
  static int[] arr = new int[30];
  public static void main(String[] args) {

//    System.out.println(1%2);

//    System.out.println(Arrays.toString(arr));
    System.out.println(solution(4));
//    System.out.println(solution(64));
//    System.out.println(solution(125));

  }
  private static int pow(int val, int two) {
    return val*two;
  }

  public static int solution(int N){

    //pre setting
    arr[0] = 1;
    int x = 1;
    for(int i=1;i<30;i++){
      x = pow(x,2);
//      System.out.println(i+" "+x);
      arr[i] = x;
    }
    int ans = 0;
    for(int i=0;i<30;i++){

      if(N>=arr[i] && N%arr[i]==0){
        ans = i;
      }
    }
    return ans;
  }
}
