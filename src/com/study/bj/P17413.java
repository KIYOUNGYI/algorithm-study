package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 단어 뒤집기 2
 * https://www.acmicpc.net/problem/17413
 *
 */
public class P17413
{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine();

    String[] temp = input.split(">");
    for(int i=0;i<temp.length;i++)
    {
      System.out.println(temp[i]);
    }


    bw.close();
  }
}
