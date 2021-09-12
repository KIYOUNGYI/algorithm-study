package com.study.bj.b2021.step1.brute_force.brute;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P6064_카잉_달력_v2 {


  static int tc;
  static int M, N, x, y;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    String s = br.readLine();
    tc = Integer.parseInt(s);

    for (int i = 0; i < tc; i++) {
      String s2 = br.readLine();
      String[] s1 = s2.split(" ");
      M = Integer.parseInt(s1[0]);//5
      N = Integer.parseInt(s1[1]);//7
      x = Integer.parseInt(s1[2])-1;//3
      y = Integer.parseInt(s1[3])-1;//2
      System.out.println("x:"+x);
      System.out.println("y:"+y);
      boolean flag = false;
      for (int k = x; k < N * M; k = k + M) {
        System.out.println("k:"+k);
        if(k%N==y){
          bw.write((k+1)+"\n");
          flag = true;
          break;
        }
      }
      if(!flag) {
        bw.write(-1+"\n");
      }
    }
    bw.flush();
    bw.close();
  }
}
