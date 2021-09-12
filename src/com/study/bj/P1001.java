package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P1001 {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(bf.readLine());
    for(int i=0;i<T;i++)
    {
      String[] temp = bf.readLine().split(" ");
      int t = Integer.parseInt(temp[0])+Integer.parseInt(temp[1]);
      bw.write(t+"\n");
    }
    bw.close();
  }
}
