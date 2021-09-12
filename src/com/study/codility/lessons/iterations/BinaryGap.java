package com.study.codility.lessons.iterations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryGap {

  static List<Integer> arrList = new ArrayList<>();
  public static void main(String[] args) {
    System.out.println(solution(529));
    arrList = new ArrayList<>();
    System.out.println(solution(20));
  }

  public static int solution(int x){

    tobin(x);
    int len = arrList.size();
    int[] ans = new int[len];
    int idx = 0;
    for(int i=len-1;i>=0;i--){
      ans[idx++] = arrList.get(i);
    }
//    System.out.println(Arrays.toString(ans));

    int max = 0;
    int cnt1=0;
    for(int i=1;i<len;i++){
      if(ans[i]==0){
        cnt1+=1;
      }else{
        if(max<cnt1){
          max = cnt1;
        }
        cnt1=0;
      }
    }

    return max;
  }

  private static void tobin(int x) {

    if(x==1){
      arrList.add(1);
      return;
    }

    if(x%2==0){
      arrList.add(0);
    }else{
      arrList.add(1);
    }
    tobin(x/2);
  }


}
