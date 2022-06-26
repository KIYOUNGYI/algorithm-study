package com.study.programmers.twotwo.levelone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 체육복 {

  static int max = 0;
  static int[] member;
  static List<Integer> reserveList = new ArrayList<>();

  public static int solution(int n, int[] lost, int[] reserve) {

    member = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      member[i] = 1;
    }

    for (int i = 0; i < lost.length; i++) {
      member[lost[i]] = 0;
    }

    for (int i : reserve) {
        reserveList.add(i);
    }

    int t = sum();
    if(t>max){
      max = t;
    }


    for(int depth=0;depth<lost.length;depth++){
      System.out.println("depth : " + depth);
      dfs(depth, lost);
    }

    return max;
  }

  //dfs 안에 for loop 필요
  public static void dfs(int depth, int[] lost){

    if(depth==lost.length){
      int t = sum();
      if(t>max){
        max = t;
      }
      return;
    }
    System.out.println("members:"+ Arrays.toString(member));
    int t = sum();
    if(t>max){
      max = t;
    }


    int v1 = lost[depth]-1;//1번 학생한테 빌리던가
    int v2 = lost[depth]+1;//3번 학생한테 빌리던가

    if(reserveList.contains(v1) && member[lost[depth]]==0){
      reserveList.remove(0);
      member[lost[depth]] = 1;
      dfs(depth+1, lost);
      reserveList.add(v1);
      member[lost[depth]] = 0;
    }
    int t2 = sum();
    if(t2>max){
      max = t2;
    }

    if(reserveList.contains(v2) && member[lost[depth]]==0){
      reserveList.remove(0);
      member[lost[depth]]=1;
      dfs(depth+1, lost);
      reserveList.add(v2);
      member[lost[depth]]=0;
    }


  }
  
  static int sum(){
    int temp=0;
    for(int i=0;i<member.length;i++){
      temp+=member[i];
    }
    return temp;
  }

  public static void main(String[] args) {

    //total, lost, reserve
//    System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
//    System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));
    System.out.println(solution(9, new int[]{2,4,6}, new int[]{3,7}));
    //1,2,3,4,6,7,8,9
  }
}
