package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P10951 {

  public static void main(String[] args) throws IOException
  {
    Scanner scan  = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    while(scan.hasNextLine())
    {
      String input = scan.nextLine();
      if(input==null){break;}
      String[] temp = input.split(" ");
      int a = Integer.parseInt(temp[0]);
      int b = Integer.parseInt(temp[1]);
      int c = a+b;
      System.out.println(c);
    }
    scan.close();
  }
}
