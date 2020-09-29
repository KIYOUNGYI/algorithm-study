package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 부분수열의 합
 * https://www.acmicpc.net/problem/1182
 * 조합 그 예전에 전수받았던 재귀 틀로 풀었다. 이거 근데 dfs로 풀수도 있는거 같다. 다음엔 dfs로 풀자
 */
public class P1182 {

  //5c1 + 5c2 + 5c3 + 5c4 + 5c5
  //20c1 + 20c2 + 20c3 + 20c4 + 20c5 + ..... + 20c20
//    static int n = 5;//11개중 5개를 뽑는다
//    static int cnt=0;
  static int depthCopy;
  static int[] input;
  static int totalChoice;
  static int destination;
  public static ArrayList<Integer> arrList = new ArrayList();
  static int cnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] x = br.readLine().split(" ");
    totalChoice = Integer.parseInt(x[0]);
    destination = Integer.parseInt(x[1]);
    input = new int[totalChoice];
    String[] y = br.readLine().split(" ");
    for (int i = 0; i < y.length; i++) {
      input[i] = Integer.parseInt(y[i]);
    }
//        System.out.println(Arrays.toString(input));
    Arrays.sort(input);
    problem();
  }

  public static void problem() {
    for (int i = 1; i <= totalChoice; i++) {
      depthCopy = i;
      recursive(0, 0);
    }
    System.out.println(cnt);
  }

  public static void sum() {
    long sum = 0;
    for (int i = 0; i < arrList.size(); i++) {
      sum += input[arrList.get(i)];
    }
    if (sum == destination) {
//            System.out.println(arrList.toString());
      cnt += 1;
    }
  }

  public static void recursive(int depth, int pivot) {
    if (depth == depthCopy) {
      sum();
      return;
    } else if (pivot == totalChoice) {
      return;
    }
    arrList.add(pivot);
    recursive(depth + 1, pivot + 1);
    int len = arrList.size();
    arrList.remove(len - 1);
    recursive(depth, pivot + 1);
  }

}