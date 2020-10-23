package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 나무 자르기 (하아 개 빠가야루)
 * https://www.acmicpc.net/problem/2805
 * 다시 풀어봐야함. 기억이 희미해지면
 */
public class P2805V2 {

  static int treeCnt;
  static long target;
  static long[] tree;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    treeCnt = Integer.parseInt(temp[0]);
    target = Integer.parseInt(temp[1]);
    tree = new long[treeCnt];
    temp = br.readLine().split(" ");
    for (int i = 0; i < temp.length; i++) {
      tree[i] = Long.parseLong(temp[i]);
    }
    Arrays.sort(tree);
    treeCut();
  }

  public static void treeCut() {

    long left = 1;
    long right = tree[tree.length - 1];
    long middle = 0;
    while (left <= right) {
      middle = (left + right) / 2;

      long sumCutTree = 0;
      sumCutTree = calculate(middle);
//      System.out.println("left : "+left+" right : "+right+" mid : "+middle+" sum : "+sumCutTree);
      if(sumCutTree==target)
      {
        System.out.println(middle);
        return;
      }
      else if (sumCutTree > target) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }
    System.out.println(right);
  }

  public static long calculate(long height) {
    long total = 0;
    for (int i = 0; i < tree.length; i++) {
      if (height < tree[i]) {
        total += (tree[i] - height);
      }
    }
    return total;
  }
}
