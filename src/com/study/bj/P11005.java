package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 진법 변환 2
 * https://www.acmicpc.net/problem/11005
 */
public class P11005 {

  static String[] arr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
      "Y", "Z"};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] temp = br.readLine().split(" ");
    int input = Integer.parseInt(temp[0]);
    int jinbup = Integer.parseInt(temp[1]);
    StringBuilder sb = new StringBuilder();

    int t = 0;
    while (input != 0) {
      t = input % jinbup;
      input = input / jinbup;
      sb.append(arr[t]);
    }
    bw.write(sb.reverse().toString());
    bw.close();
//    System.out.println(sb.reverse());

  }
}
