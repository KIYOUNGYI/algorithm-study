package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Base Conversion
 * https://www.acmicpc.net/problem/11576
 */
public class P11576 {

  static int futureJB, jungJB;
  static int futureJarisu;
  static int[] futureNum;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // 정이 진법으로 출력
    String[] temp = br.readLine().split(" ");
    futureJB = Integer.parseInt(temp[0]);
    jungJB = Integer.parseInt(temp[1]);
    futureJarisu = Integer.parseInt(br.readLine());
    futureNum = new int[futureJarisu];
    String[] temp2 = br.readLine().split(" ");
    int idx = 0;
    for (int i = futureJarisu - 1; i >= 0; i--) {
      futureNum[idx++] = Integer.parseInt(temp2[i]);
    }
//    System.out.println(Arrays.toString(futureNum));
    //convert nums to decimal
    int t = 0;
    for (int jarisu = 0; jarisu < futureJarisu; jarisu++) {
      t += pow(futureNum[jarisu], jarisu, futureJB);
    }
//    System.out.println(t);
    //convert decimal to jung's way
    ArrayList<Integer> answer = new ArrayList<>();
    while (t != 0) {
      answer.add(t % jungJB);
      t = t / jungJB;
    }
    for (int i = answer.size() - 1; i >= 1; i--) {
      bw.write(answer.get(i) + " ");
    }
    bw.write(answer.get(0) + "\n");
    bw.close();
  }

  private static int pow(int num, int jarisu, int futureJB) {
    int t = 1;
    for (int i = 0; i < jarisu; i++) {
      t = t * futureJB;
    }
    return num * t;
  }

}
