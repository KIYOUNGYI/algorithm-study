package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 다시는 풀지 말자
 */
public class P10953 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 1; i <= t; i++) {
      String[] temp = br.readLine().split(",");
//      System.out.println(temp);
//      System.out.println(Arrays.toString(temp2));
      System.out.println(Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]));
    }
  }
}
