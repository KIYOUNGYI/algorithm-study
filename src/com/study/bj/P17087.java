package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P17087 {

  static int cnt;
  static int start;
  static int[] arr;
  static int difference = Integer.MAX_VALUE;
  static int jjakCnt = 0;
  static int hollCnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] temp = br.readLine().split(" ");
    cnt = Integer.parseInt(temp[0]);
    start = Integer.parseInt(temp[1]);
    arr = new int[cnt];
    String[] temp2 = br.readLine().split(" ");

    for (int i = 0; i < cnt; i++) {
      arr[i] = Integer.parseInt(temp2[i]);
      if (arr[i] % 2 == 0) {
        jjakCnt += 1;
      } else {
        hollCnt += 1;
      }
    }
    if (jjakCnt > 0 && hollCnt > 0) {
      difference = 1;
      bw.write(difference+"\n");
      bw.close();
      return;
    }

    for (int i = 0; i < arr.length; i++) {
      int t = abs(start - arr[i]);
      if (t < difference) {
        difference = t;
      }
    }

    if(difference==1){
      bw.write(difference+"\n");
      bw.close();
      return;
    }

    if(start%2==0 && hollCnt>0){
      bw.write(difference+"\n");
      bw.close();
      return;
    }

    if(start%2==1 && jjakCnt>1)
    {
      bw.write(difference+"\n");
      bw.close();
      return;
    }

    while (true) {
      int cnt = 0;
      for (int i = 0; i < arr.length; i++) {
        if ((arr[i] - start) % difference == 0) {
          cnt += 1;
        }
      }
      if (cnt == arr.length) {
        break;
      } else {
        difference = difference - 2;
      }
    }
    bw.write(difference + "\n");
    bw.close();

  }

  static int abs(int x) {
    return x > 0 ? x : -x;
  }
}
