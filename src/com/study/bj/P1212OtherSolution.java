package com.study.bj;

import java.util.Scanner;

public class P1212OtherSolution {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    if(s.equals("0")) System.out.println(0);
    else{
      StringBuilder sb1 = new StringBuilder();
      StringBuilder sb2 = new StringBuilder();
      StringBuilder sb3 = new StringBuilder();
      sb1.append(s);
      for(int i=0;i<s.length();++i){
        int tmp = Integer.parseInt(sb1.substring(i, i+1).toString());
        for(int j=0;j<3;++j){
          sb2.append(tmp%2);
          tmp/=2;
        }
        sb3.append(sb2.reverse());
        sb2.setLength(0);
      }
      System.out.println(sb3.substring(sb3.indexOf("1")));
    }
    sc.close();
  }
}
