package com.study.bj.b2021.middleclass1;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {

  public static int[] inputArr;
  // 입력된 연산자 정보가 들어갈 리스트
  public static ArrayList<Integer> inputList;
  public static boolean[] check;
  // 연산자에 대한 모든 순열 정보가 들어갈 리스트
  public static ArrayList<Integer> outputList;
  public static int min = Integer.MAX_VALUE;
  public static int max = Integer.MIN_VALUE;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    inputArr = new int[n];

    for (int i = 0; i < n; i++) {
      inputArr[i] = scan.nextInt();
    }

    inputList = new ArrayList<Integer>();

    check = new boolean[n - 1];//숫자와 숫자 사이

    outputList = new ArrayList<Integer>();

    for (int i = 0; i < 4; i++) {
      int num = scan.nextInt();
      if (num > 0) {
        for (int j = 0; j < num; j++) {
          inputList.add(i);
        }
      }
    }
    System.out.println("inputList:" + inputList.toString());//기호 리스트

//    dfs(n-1, 0);
    myDfs(0, 0);
  }

  public static void myDfs(int depth, int y) {

    if(depth==check.length){
      System.out.println(">"+outputList.toString());
      return;
    }
    if(y==inputList.size()){
      return;
    }


    outputList.add(inputList.get(y));
    myDfs(depth + 1, y+1);

    outputList.remove(outputList.size()-1);
    myDfs(depth,y+1);

  }


  public static void dfs(int n, int depth) {

    if(depth == n) {
      System.out.println(outputList.toString());
//      calAnswer(n);
      return;
    }
    //[ a , b , c,  d]
    //[   x   x   x  ]
    for(int i = 0; i < n; i++) {
      if(!check[i]) {
        check[i] = true;
        outputList.add(inputList.get(i));
        dfs(n, depth + 1);
        outputList.remove(outputList.size() - 1);
        check[i] = false;
      }
    }
  }



}