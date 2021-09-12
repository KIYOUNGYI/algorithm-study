package com.study.bj.b2021.step1.math;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//폭파
public class P17425_약수의_합_v2 {

  static int size = 1_000_050;
  static int size2 = 1_050;
  static int tc;
  static int n;
  static long[] g;
  static long[] f;
  public static void main(String[] args) throws IOException {

    Scanner scan = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    tc = scan.nextInt();
    g = new long[1_000_050];
    f = new long[1_000_050];
    for(int i=1;i<size2;i++){
      //f(i);
      long sum = 0;
      for(int j=1;j<=i;j++){
        if(i%j==0){
          sum=sum+(i/j);
        }
      }
      f[i] =sum;
    }

    System.out.println(f[2]);

    bw.flush();
    bw.close();
  }
}
