package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 수 정렬하기 3 https://www.acmicpc.net/problem/10989 bufferReader,StringBuilder 사용 bufferwriter, outputstreamwriter, sout 써야함. bw는 꼭 close 해줘야 함.
 */
public class P10989 {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[10020];
    Integer n = Integer.parseInt(bf.readLine());
    StringBuilder sb = new StringBuilder();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < n; i++) {
      Integer x = Integer.parseInt(bf.readLine());
      arr[x] += 1;
    }

    for (int i = 0; i <= 10000; i++) {
      if (arr[i] != 0) {
        int t = arr[i];
        for (int j = 0; j < t; j++) {
//                    sb.append(i+"\n");
          bw.write(i + "\n");
//                    System.out.println(i);
        }
      }
    }
    bw.close();
//        System.out.println(sb.toString());
  }

}
