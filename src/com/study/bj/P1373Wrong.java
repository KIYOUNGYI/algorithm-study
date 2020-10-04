package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1373Wrong {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String input = br.readLine();
    int t = convertBinaryToDecimal(input);
    int ans = convBinaryToAnswer(t);
    bw.write(ans + "\n");
    bw.close();
  }

  private static int convBinaryToAnswer(int t) {
    StringBuilder sb = new StringBuilder();
    while (t != 0) {
      sb.append(t % 8);
      t = t / 8;
    }
    return Integer.parseInt(String.valueOf(sb.reverse()));
  }

  private static int convertBinaryToDecimal(String input) {
    int t = 0;
    int idx = 0;
    for (int i = input.length() - 1; i >= 0; i--) {
      t += pow(Integer.parseInt(String.valueOf(input.charAt(i))), idx, 2);
      idx += 1;
    }
    return t;
  }

  private static int pow(int num, int jarisu, int jinbup) {
    int t = 1;
    for (int i = 0; i < jarisu; i++) {
      t = t * jinbup;
    }
    return num * t;
  }
}
