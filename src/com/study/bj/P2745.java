package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 진법 변환
 * https://www.acmicpc.net/problem/2745
 */
public class P2745 {

  static String[] arr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
      "Y", "Z"};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    String input = temp[0];
    int jinbup = Integer.parseInt(temp[1]);
    StringBuilder sb = new StringBuilder();
    for (int i = input.length() - 1; i >= 0; i--) {
      sb.append(input.charAt(i));
    }
    String reversedInput = sb.toString();
    int a = 0;
    for (int jarisu = 0; jarisu < reversedInput.length(); jarisu++) {
      int t = pow(reversedInput.charAt(jarisu), jarisu, jinbup);
      a += t;
    }
    System.out.println(a);
  }

  private static int pow(char charAt, int seung, int jinbup) {
    int temp = 0;
    for (int x = 0; x < arr.length; x++) {
      if (charAt == arr[x].charAt(0)) {
        temp = x;
        break;
      }
    }
    int t = 1;
    for (int x = 0; x < seung; x++) {
      t = t * jinbup;
    }
    return temp * t;
  }

}
